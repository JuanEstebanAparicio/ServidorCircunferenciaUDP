package juanesteban.circunferencia.aplicacion.servicios;

import java.util.Objects;
import juanesteban.circunferencia.aplicacion.dto.CalcularCircunferenciaCommand;
import juanesteban.circunferencia.aplicacion.dto.ResultadoCircunferenciaDto;
import juanesteban.circunferencia.aplicacion.mapper.CalculoMapper;
import juanesteban.circunferencia.aplicacion.puertos.entrada.CalcularCircunferenciaInputPort;
import juanesteban.circunferencia.dominio.modelos.Calculo;
import juanesteban.circunferencia.dominio.modelos.Resultado;

/**
 * Servicio de aplicación que implementa el caso de uso de calcular la circunferencia.
 * Responsabilidad única: orquestar la conversión del comando a dominio, invocar la lógica del
 * dominio y retornar el resultado en formato DTO.
 */
public final class CalcularCircunferenciaService implements CalcularCircunferenciaInputPort {

  private final CalculoMapper calculoMapper;

  public CalcularCircunferenciaService(final CalculoMapper calculoMapper) {
    this.calculoMapper =
        Objects.requireNonNull(calculoMapper, "El mapper de cálculo es obligatorio.");
  }

  @Override
  public ResultadoCircunferenciaDto calcular(final CalcularCircunferenciaCommand comando) {
    final Calculo calculo = calculoMapper.toDomain(comando);
    final Resultado resultado = calculo.calcular();
    return calculoMapper.toDto(resultado);
  }
}