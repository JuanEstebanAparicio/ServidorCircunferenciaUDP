/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.aplicacion.puertos.entrada;

import juanesteban.circunferencia.aplicacion.dto.CalcularCircunferenciaCommand;
import juanesteban.circunferencia.aplicacion.dto.ResultadoCircunferenciaDto;

/**
 *
 * @author apari
 */
public interface CalcularCircunferenciaInputPort {
    
    ResultadoCircunferenciaDto calcular(CalcularCircunferenciaCommand comando);
}
