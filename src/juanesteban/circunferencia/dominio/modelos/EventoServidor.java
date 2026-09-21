/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.dominio.modelos;

import java.time.LocalDateTime;
/**
 *
 * @author apari
 */
public class EventoServidor {

private final LocalDateTime fechaHora;
private final String categoria;
private final String endpoint;
private final String descripcion;

public EventoServidor(final String categoria, final String endpoint, final String descripcion) {
    this.fechaHora = LocalDateTime.now();
    this.categoria = categoria;
    this.endpoint = endpoint;
    this.descripcion = descripcion;
}

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
