package juanesteban.circunferencia.aplicacion.mapper;

import java.util.Objects;
import juanesteban.circunferencia.aplicacion.dto.ProcesarPeticionUdpCommand;
import juanesteban.circunferencia.aplicacion.excepciones.ComandoInvalidoException;
import juanesteban.circunferencia.dominio.vo.Destinatario;

/**
 * Mapper de la capa de aplicación. Responsabilidad única: convertir datos de comandos de petición
 * a objetos de valor del dominio.
 */
public final class PeticionMapper {

  public Destinatario toDestinatario(final ProcesarPeticionUdpCommand comando) {
    if (Objects.isNull(comando)) {
      throw new ComandoInvalidoException("El comando de petición no puede ser nulo.");
    }
    return new Destinatario(comando.ipCliente(), comando.puertoCliente());
  }
}