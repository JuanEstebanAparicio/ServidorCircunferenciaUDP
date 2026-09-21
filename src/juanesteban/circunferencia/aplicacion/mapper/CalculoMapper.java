/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.aplicacion.mapper;

import java.util.Objects;
import juanesteban.circunferencia.aplicacion.dto.CalcularCircunferenciaCommand;
import juanesteban.circunferencia.aplicacion.dto.ResultadoCircunferenciaDto;
import juanesteban.circunferencia.aplicacion.excepciones.ComandoInvalidoException;
import juanesteban.circunferencia.dominio.modelos.Calculo;
import juanesteban.circunferencia.dominio.modelos.Resultado;
import juanesteban.circunferencia.dominio.vo.Radio;

/**
 *
 * @author apari
 */
public final class CalculoMapper {
    
    public Calculo toDomain(final CalcularCircunferenciaCommand comando) {
      if (Objects.isNull(comando)) {
        throw new ComandoInvalidoException("El comando de cálculo no puede ser nulo.");
       }
      return new Calculo(new Radio(comando.radio()));
    }
    
    public Calculo toDomain(final double valorRadio) {
    return new Calculo(new Radio(valorRadio));
    }
    public ResultadoCircunferenciaDto toDto(final Resultado resultado) {
    if (Objects.isNull(resultado)) {
      throw new ComandoInvalidoException("El resultado del cálculo no puede ser nulo.");
    }
    return new ResultadoCircunferenciaDto(
        resultado.getLongitud(), resultado.getLongitudFormateada(), resultado.getMensaje());
    }
}
