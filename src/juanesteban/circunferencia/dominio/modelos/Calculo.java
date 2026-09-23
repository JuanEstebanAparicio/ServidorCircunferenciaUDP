/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.dominio.modelos;

import java.util.Objects;
import juanesteban.circunferencia.dominio.excepciones.CalculoInvalidoException;
import juanesteban.circunferencia.dominio.vo.Radio;

/**
 *
 * @author apari
 */
public final class Calculo {
    
    private static final String MENSAJE_OK = "Longitud calculada correctamente";
    
    private final Radio radio;
    
    public Calculo(final Radio radio) {
        if (Objects.isNull(radio)) {
            throw new CalculoInvalidoException(
            "El radio es obligatorio para calcular la circunferencia. ");
        }
        this.radio = radio;
    }
    
      /**
     * Calcula la longitud de la circunferencia a partir del radio.
     *
     * @return Objeto Resultado con la longitud y el mensaje de éxito.
     */
       public Resultado calcular() {
           final double longitud = 2 * Math.PI * radio.valor();
           return new Resultado(longitud, MENSAJE_OK);
       }

    public Radio getRadio() {
        return radio;
    }
}
