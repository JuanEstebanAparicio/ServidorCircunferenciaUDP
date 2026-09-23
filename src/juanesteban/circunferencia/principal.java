package juanesteban.circunferencia;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import juanesteban.circunferencia.adaptadores.red.AdaptadorControlServidorRed;
import juanesteban.circunferencia.adaptadores.red.AdaptadorNotificacionEvento;
import juanesteban.circunferencia.adaptadores.red.AdaptadorSalidaUdp;
import juanesteban.circunferencia.adaptadores.red.CanalUdp;
import juanesteban.circunferencia.adaptadores.red.mapper.UdpNetworkMapper;
import juanesteban.circunferencia.aplicacion.mapper.CalculoMapper;
import juanesteban.circunferencia.aplicacion.mapper.PeticionMapper;
import juanesteban.circunferencia.aplicacion.puertos.entrada.GestionarServidorInputPort;
import juanesteban.circunferencia.aplicacion.puertos.entrada.ProcesarPeticionUdpInputPort;
import juanesteban.circunferencia.aplicacion.servicios.GestionarServidorService;
import juanesteban.circunferencia.aplicacion.servicios.ProcesarPeticionUdpService;
import juanesteban.circunferencia.dominio.puertos.salida.ControladorServidorRedPort;
import juanesteban.circunferencia.dominio.puertos.salida.PuertoSalidaRed;
import juanesteban.circunferencia.entrypoint.gui.ServidorFrame;
import juanesteban.circunferencia.entrypoint.udp.ReceptorPeticionesUdp;

/**
 * Punto de entrada del programa (Composition Root). Responsabilidad única: ensamblar las
 * dependencias según los principios SOLID y la Arquitectura Hexagonal, y lanzar la interfaz de
 * usuario.
 */
public class principal {

    private static final System.Logger LOG = System.getLogger(principal.class.getName());

    private principal() {
        // Evita instanciación: clase de arranque estática
    }

    public static void main(final String[] args) {
        aplicarLookAndFeel();

        // 1. Infraestructura de red compartida
        final CanalUdp canalUdp = new CanalUdp();
        final AdaptadorNotificacionEvento notificador = new AdaptadorNotificacionEvento();
        final UdpNetworkMapper redMapper = new UdpNetworkMapper();
        final PuertoSalidaRed puertoSalidaRed = new AdaptadorSalidaUdp(canalUdp, redMapper, notificador);

        // 2. Mappers de aplicación
        final PeticionMapper peticionMapper = new PeticionMapper();
        final CalculoMapper calculoMapper = new CalculoMapper();

        // 3. Casos de uso (servicios de aplicación)
        final ProcesarPeticionUdpInputPort procesarPeticionPort =
                new ProcesarPeticionUdpService(puertoSalidaRed, notificador, peticionMapper, calculoMapper);

        // 4. Entrypoints
        final ReceptorPeticionesUdp receptorUdp =
                new ReceptorPeticionesUdp(canalUdp, procesarPeticionPort, notificador);

        final ControladorServidorRedPort controladorRed =
                new AdaptadorControlServidorRed(canalUdp, receptorUdp::iniciar, receptorUdp::detener);

        final GestionarServidorInputPort gestionarServidorPort =
                new GestionarServidorService(controladorRed, notificador);

        // 5. Lanzar GUI en el Event Dispatch Thread de Swing
        SwingUtilities.invokeLater(
                () -> {
                    final ServidorFrame frame = new ServidorFrame(gestionarServidorPort);
                    notificador.registrarObservador(frame);
                    frame.setVisible(true);
                });
    }

    private static void aplicarLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException excepcion) {
            LOG.log(
                    System.Logger.Level.DEBUG,
                    "No fue posible aplicar la apariencia del sistema; se usará la predeterminada.",
                    excepcion);
        }
    }
}