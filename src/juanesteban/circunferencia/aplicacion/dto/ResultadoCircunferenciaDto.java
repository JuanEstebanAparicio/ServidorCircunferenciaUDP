package juanesteban.circunferencia.aplicacion.dto;

/** DTO que contiene el resultado del cálculo de la circunferencia para la capa de aplicación. */
public record ResultadoCircunferenciaDto(double longitud, String longitudFormateada, String mensaje) {
}