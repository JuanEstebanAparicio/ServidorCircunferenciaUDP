/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.adaptadores.red;

import juanesteban.circunferencia.dominio.enums.EstadoServidor;
import juanesteban.circunferencia.dominio.modelos.EventoServidor;
/**
 *
 * @author apari
 */
public interface ObservadorServidor {
    
    void onEvento(EventoServidor evento);
    
    void onCambioEstado(EstadoServidor nuevoEstado, int puerto);
}
