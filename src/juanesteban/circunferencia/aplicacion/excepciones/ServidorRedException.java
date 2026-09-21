/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.aplicacion.excepciones;

import java.io.Serial;

/**
 *
 * @author apari
 */
public final class ServidorRedException extends Exception {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    public ServidorRedException(final String mensaje, final Throwable causa) {
        super(mensaje, causa);
    }
}
