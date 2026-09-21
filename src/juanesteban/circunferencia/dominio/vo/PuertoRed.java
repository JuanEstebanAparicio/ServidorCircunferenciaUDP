/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.dominio.vo;

import juanesteban.circunferencia.dominio.excepciones.PuertoIncorrectoException;

/**
 *
 * @author apari
 */
public record PuertoRed(int valor){

    public PuertoRed {
        if(valor < 1024 || valor > 65535) {
            throw new PuertoIncorrectoException("El puerto debe ser un número entre 1024 y 65535.");
        }
    }
}
