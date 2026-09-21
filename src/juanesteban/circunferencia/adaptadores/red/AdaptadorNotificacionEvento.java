package juanesteban.circunferencia.adaptadores.red;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import juanesteban.circunferencia.dominio.enums.EstadoServidor;
import juanesteban.circunferencia.dominio.modelos.EventoServidor;
import juanesteban.circunferencia.dominio.puertos.salida.PuertoNotificacionEvento;

/**
 * Adaptador de salida para la publicación de eventos del dominio hacia la interfaz gráfica u otros
 * observadores.
 */
public final class AdaptadorNotificacionEvento implements PuertoNotificacionEvento {

  private final List<ObservadorServidor> observadores = new CopyOnWriteArrayList<>();

  public void registrarObservador(final ObservadorServidor observador) {
    if (Objects.nonNull(observador) && !observadores.contains(observador)) {
      observadores.add(observador);
    }
  }

  public void removerObservador(final ObservadorServidor observador) {
    observadores.remove(observador);
  }

  @Override
  public void notificarEvento(final EventoServidor evento) {
    Objects.requireNonNull(evento, "El evento es obligatorio.");
    for (final ObservadorServidor observador : observadores) {
      observador.onEvento(evento);
    }
  }

  @Override
  public void notificarCambioEstado(final EstadoServidor nuevoEstado, final int puerto) {
    Objects.requireNonNull(nuevoEstado, "El estado es obligatorio.");
    for (final ObservadorServidor observador : observadores) {
      observador.onCambioEstado(nuevoEstado, puerto);
    }
  }
}