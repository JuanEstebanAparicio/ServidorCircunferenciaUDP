/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juanesteban.circunferencia.dominio.puertos.salida;

import juanesteban.circunferencia.aplicacion.excepciones.ServidorRedException;
import juanesteban.circunferencia.dominio.vo.PuertoRed;


/**
 *
 * @author apari
 */
public interface ControladorServidorRedPort {
    
    void iniciar(PuertoRed puerto) throws ServidorRedException;
    
    void detener();
    
    boolean isActivo();
    
    PuertoRed getPuertoActual();
    
}
