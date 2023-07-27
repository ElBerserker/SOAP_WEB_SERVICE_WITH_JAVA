// Autor: Raul Hernandez Lopez @Neo
// Correo: freeenergy1975@gmail.com
// Fecha: 28 de Enero del 2023

package com.lynx.sistemasatisfaccionws.entidades;

public class EncuestaDTO {
    private int nivel_satisfaccion;
    private String comentario;
    private String folio;
    private String fecha;
    
   public EncuestaDTO(int nivel_satisfaccion, String comentario, String folio, String fecha){
       this.nivel_satisfaccion = nivel_satisfaccion;
       this.comentario = comentario;
       this.folio = folio;
       this.fecha = fecha;
   }
   
   public EncuestaDTO(int nivel_satisfaccion, String comentario, String folio){
       this.nivel_satisfaccion = nivel_satisfaccion;
       this.comentario = comentario;
       this.folio = folio;
   }

    public int getNivel_satisfaccion() {
        return nivel_satisfaccion;
    }

    public String getComentario() {
        return comentario;
    }

    public String getFolio() {
        return folio;
    }

    public String getFecha() {
        return fecha;
    }
    //Sobreescritura del metodo toString.
    @Override
    public String toString(){
    return "Encuesta( n.s: " + nivel_satisfaccion
            + ", comentario: " + comentario
            + ", folio: " + folio
            + ", fecha: " + fecha;
    }
}
