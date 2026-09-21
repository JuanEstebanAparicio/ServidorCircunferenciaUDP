/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.dominio.modelos;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Objects;
import juanesteban.circunferencia.dominio.excepciones.ResultadoInvalidoException;
/**
 *
 * @author apari
 */
public final class Resultado {
    
    private final double longitud;
    private final String mensaje;
    
    public Resultado(final double longitud, final String mensaje) {
        if (!Double.isFinite(longitud) || Objects.isNull(mensaje)) {
            throw new ResultadoInvalidoException(
            "El resultado de la circunferencia contiene datos invalidos.");
        }
        this.longitud = longitud;
        this.mensaje = mensaje;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public String getLongitudFormateada() {
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        final DecimalFormat df = new DecimalFormat("#.##", symbols);
        return df.format(longitud);
    }
}
