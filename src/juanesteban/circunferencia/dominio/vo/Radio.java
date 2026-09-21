/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.dominio.vo;

import juanesteban.circunferencia.dominio.excepciones.RadioIncorrectoException;
/**
 *
 * @author apari
 */

public record Radio(double valor){

    private static final String MENSAJE_ERROR = "Radio Incorrecto: debe ser mayor a 0";
}

