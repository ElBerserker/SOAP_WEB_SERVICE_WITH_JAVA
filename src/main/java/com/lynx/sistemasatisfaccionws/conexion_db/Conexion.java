/* Autor: Raul  Hernandez Lopez @Neo
 * Correo:  freeenergy1975@gmail.com
 * Fecha:Lunes 28 de Agosto del 2023
 * Descripcion: Creacion de una clase de conexion empleando el patron de disenio
 * singleton para asegurar el uso de una sola instancia,mejorando el rendimiento
 * de la aplicacion.
 */
package com.lynx.sistemasatisfaccionws.conexion_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private static Conexion instancia_conexion;        
    private String cadena__de_conexion;
    private String usuario_base_de_datos;
    private String contrasenia_base_de_datos;    
    private Connection conecction;
    /* Establecer como privado nuestro metodo constructor nos ayudara garantizar 
     * que solo se pueda crear una instancia de esta clase.*/
    private Conexion() throws SQLException, ClassNotFoundException{    
        /* Definicion de las credenciales para la base de datos. */
        cadena__de_conexion = "jdbc:mysql://192.168.1.70:3306/satisfaction_system";
        usuario_base_de_datos = "Berserker_db";
        contrasenia_base_de_datos = "db_maria1.1";       
        startConnection();
    }
    
    public static Conexion obtenerInstancia() throws SQLException, ClassNotFoundException{
        if(instancia_conexion == null){
            instancia_conexion = new Conexion();            
                    Class.forName("com.mysql.cj.jdbc.Driver"); 
        }
        return instancia_conexion;
    }
                    
    //Sobrecarga del metodo para cerrar los objetos que se envian como parametros.
    public static void close(ResultSet result) throws SQLException{
        result.close();
    }
    
    public static void close(Statement statement) throws SQLException{
        statement.close();
    }
    
    public static void close(PreparedStatement prepare_statement) throws SQLException{
        prepare_statement.close();
    }
    
    public static void close(Connection conexion) throws SQLException{
        conexion.close();
    }
    
    /* Metodos Getters y Setters */    
    public String getCadena__de_conexion() {
        return cadena__de_conexion;
    }

    public void setCadena__de_conexion(String cadena__de_conexion) {
        this.cadena__de_conexion = cadena__de_conexion;
    }

    public String getUsuario_base_de_datos() {
        return usuario_base_de_datos;
    }

    public void setUsuario_base_de_datos(String usuario_base_de_datos) {
        this.usuario_base_de_datos = usuario_base_de_datos;
    }

    public String getContrasenia_base_de_datos() {
        return contrasenia_base_de_datos;
    }


    public void setContrasenia_base_de_datos(String contrasenia_base_de_datos) {
        this.contrasenia_base_de_datos = contrasenia_base_de_datos;
    }

    public Connection getConecction() throws ClassNotFoundException, SQLException {
        if (conecction.isClosed()){
            startConnection();
        }    
        return conecction;
    }

    public void setConecction(Connection conecction) {
        this.conecction = conecction;
    }
    
    public void startConnection() throws ClassNotFoundException, SQLException{
        /* Inicializacion de nuestra conexion a la base de datos*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        conecction = DriverManager.getConnection(cadena__de_conexion, 
                                                usuario_base_de_datos,
                                                contrasenia_base_de_datos);
    }
}
