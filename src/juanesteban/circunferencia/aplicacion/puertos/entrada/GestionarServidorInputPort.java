/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.aplicacion.puertos.entrada;

import juanesteban.circunferencia.aplicacion.excepciones.ServidorRedException;
/**
 *
 * @author apari
 */
public interface GestionarServidorInputPort {
    
    void iniciarServidor(int puerto) throws ServidorRedException;
    
    void detenerServidor();
    
    boolean estaCorriendo();
    
    int getPuertoActual();
}
