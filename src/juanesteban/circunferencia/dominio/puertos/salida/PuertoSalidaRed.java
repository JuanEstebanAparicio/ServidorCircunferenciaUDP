/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juanesteban.circunferencia.dominio.puertos.salida;

import juanesteban.circunferencia.dominio.modelos.RespuestaCliente;

/**
 *
 * @author apari
 */
public interface PuertoSalidaRed {
    
    void enviarRespuesta(RespuestaCliente respuesta);
}
