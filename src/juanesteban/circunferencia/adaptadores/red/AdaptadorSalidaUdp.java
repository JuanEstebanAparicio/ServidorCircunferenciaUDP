package juanesteban.circunferencia.adaptadores.red;

import java.io.IOException;
import java.util.Objects;
import juanesteban.circunferencia.adaptadores.red.mapper.UdpNetworkMapper;
import juanesteban.circunferencia.adaptadores.red.response.UdpResponse;
import juanesteban.circunferencia.dominio.modelos.EventoServidor;
import juanesteban.circunferencia.dominio.modelos.RespuestaCliente;
import juanesteban.circunferencia.dominio.puertos.salida.PuertoNotificacionEvento;
import juanesteban.circunferencia.dominio.puertos.salida.PuertoSalidaRed;

/**
 * Adaptador de salida que implementa el puerto de salida de red (PuertoSalidaRed). Responsabilidad
 * única: transformar objetos de dominio en datagramas UDP y transmitirlos hacia el cliente a
 * través del canal de red.
 */
public final class AdaptadorSalidaUdp implements PuertoSalidaRed {

  private final CanalUdp canalUdp;
  private final UdpNetworkMapper mapper;
  private final PuertoNotificacionEvento notificador;

  public AdaptadorSalidaUdp(
      final CanalUdp canalUdp,
      final UdpNetworkMapper mapper,
      final PuertoNotificacionEvento notificador) {
    this.canalUdp = Objects.requireNonNull(canalUdp, "El canal UDP es obligatorio.");
    this.mapper = Objects.requireNonNull(mapper, "El mapper UDP es obligatorio.");
    this.notificador = Objects.requireNonNull(notificador, "El notificador es obligatorio.");
  }

  @Override
  public void enviarRespuesta(final RespuestaCliente respuesta) {
    Objects.requireNonNull(respuesta, "La respuesta es obligatoria.");

    try {
      final UdpResponse udpResponse = mapper.toNetworkResponse(respuesta);
      canalUdp.enviar(udpResponse);
    } catch (final IOException excepcion) {
      notificador.notificarEvento(
          new EventoServidor(
              "ERROR",
              respuesta.getDestinatario().endpoint(),
              "Fallo al enviar datagrama UDP: " + excepcion.getMessage()));
    }
  }
}