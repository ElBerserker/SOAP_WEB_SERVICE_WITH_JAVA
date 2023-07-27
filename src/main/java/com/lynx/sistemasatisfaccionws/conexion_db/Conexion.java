// Autor: Raul Hernandez Lopez @Neo
// Correo: freeenergy1975@gmail.com
// Fecha: 28 de Enero del 2023

package com.lynx.sistemasatisfaccionws.conexion_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.*;

public class Conexion {
    //definicion de las credenciales para la base de datos.
    public static String cadena__de_conexion = "jdbc:mysql://www.lynx.model:3306/satisfaction_system";
    public static String usuario_base_de_datos = "Berserker_db";
    public static String contrasenia_base_de_datos = "db_maria1.1";
    //public static String CONTROLADOR = "com.mysql.jdbc.Driver";
    
    //Retorna un objeto de tipo conexion
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
            //Class.forName(CONTROLADOR);
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection(cadena__de_conexion, usuario_base_de_datos, contrasenia_base_de_datos);
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
}
