/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juanesteban.circunferencia.dominio.puertos.salida;

import juanesteban.circunferencia.dominio.enums.EstadoServidor;
import juanesteban.circunferencia.dominio.modelos.EventoServidor;
/**
 *
 * @author apari
 */
public interface PuertoNotificacionEvento {
    
    void notificarEvento(EventoServidor evento);
    
    void notificarCambioEstado(EstadoServidor nuevoEstado, int puerto);
}
