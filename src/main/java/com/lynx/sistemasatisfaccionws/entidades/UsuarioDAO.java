// Autor: Raul Hernandez Lopez @Neo
// Correo: freeenergy1975@gmail.com
// Fecha: 28 de Enero del 2023
package com.lynx.sistemasatisfaccionws.entidades;

import com.lynx.sistemasatisfaccionws.conexion_db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    // Definicion de la cadena de consulta.
    private static final String SQL_SELECT = "SELECT * FROM user";
    // Definicion de la cadena de insercion.
    private static final String SQL_INSERT = "INSERT user(name_of_user, password, type_of_user, status) VALUES (?, ?, ?, ?)";
    // Definicion de la cadena de actualizacion.
    private static final String SQL_UPDATE = "UPDATE user SET name_of_user = ?, password = ?, type_of_user = ? , status = ? WHERE name_of_user = ?";
    // Definicion de la cadena de eliminacion.
    private static final String SQL_DELETE = "DELETE FROM user WHERE name_of_user = ?";
    // Definicion de cadena de busqueda de usuario por nombre.
    private static final String SQL_SEARCH_USER = "CALL buscarUsuario(?)";
        
    public List<UsuarioDTO> consultarTodosLosUsuarios() throws ClassNotFoundException, SQLException {
        
        Conexion conexion = Conexion.obtenerInstancia();
        /* Declaracion de los objetos que se implementaran para la consulta de
           base de datos, ya que esta consulta retornara mas de un registro de
           la base de datos es necesario que se emplee una lista de objetos de
           tipo UsuarioDTO */
        Connection connection = null;
        PreparedStatement sentencia_sql = null;
        ResultSet result_consulta = null;
        UsuarioDTO usuario = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();
        
        try {
            /* La llamada a la instancia de la clase Conexion que nos brindara 
             * el objeto de tipo conexion.*/            
            connection = conexion.getConecction();
            /* Una vez establecida la coneccion, precompilamos la consulta.*/
            sentencia_sql = connection.prepareStatement(SQL_SELECT);
            /* Despues de ejecutar la sentencia es necesario almacenar los datos 
               obtenidos, asi que se los guardamos en un objeto de tipo ReultSet*/
            result_consulta = sentencia_sql.executeQuery();

            while (result_consulta.next()) {
                String name_of_user = result_consulta.getString("name_of_user");              
                String type_of_user = result_consulta.getString("type_of_user");
                String status = result_consulta.getString("status");
                /* inicializacion por medio del metodo contructor sobrecargado.*/
                usuario = new UsuarioDTO(name_of_user, type_of_user, status);
                /* Con cada registro existente se crea y se aniade un objeto de 
                tipo usuario a la lista.*/
                usuarios.add(usuario);
            }
        } catch (SQLException sql_exception) {
            sql_exception.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(result_consulta);
                Conexion.close(sentencia_sql);
                Conexion.close(connection);
            } catch (SQLException sql_exception) {
                sql_exception.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public void InsertarUsuario(UsuarioDTO usuario) 
            throws SQLException, ClassNotFoundException {
        
        Conexion conexion = Conexion.obtenerInstancia();
        Connection connection = null;
        PreparedStatement sentencia_sql = null;
        int numero_registros_db = 0;

        try {
            connection = conexion.getConecction();
            /* LLamada a la sentencia de insercion con los atributos 
               del objeto usuario */
            sentencia_sql = connection.prepareStatement(SQL_INSERT);

            sentencia_sql.setString(1, usuario.getName_of_user());
            sentencia_sql.setString(2, usuario.getPassword());
            sentencia_sql.setString(3, usuario.getType_of_user());
            sentencia_sql.setString(4, usuario.getStatus());

            /* Ejecuta la insercion y actualiza la base de datos, executeUpdate 
               es utilizado para inserciones, actualizaciones y eliminaciones.*/
            numero_registros_db = sentencia_sql.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }finally {
            try {
                Conexion.close(sentencia_sql);
                Conexion.close(connection);
            } catch (SQLException sql_exception) {
                sql_exception.printStackTrace(System.out);
            }
        }
    }

    public int actualizarUsuario(UsuarioDTO usuario, String name_of_user) 
            throws SQLException, ClassNotFoundException {
        
        Conexion conexion = Conexion.obtenerInstancia();
        Connection connection = null;
        PreparedStatement sentencia_sql = null;
        int numero_registros_db = 0;

        try {
            connection = conexion.getConecction();
            /* LLamada a la sentencia de insercion con los atributos 
               del objeto usuario */
            sentencia_sql = connection.prepareStatement(SQL_UPDATE);

            sentencia_sql.setString(1, usuario.getName_of_user());
            sentencia_sql.setString(2, usuario.getPassword());
            sentencia_sql.setString(3, usuario.getType_of_user());
            sentencia_sql.setString(4, usuario.getStatus());
            sentencia_sql.setString(5, name_of_user);

            /* Ejecuta la insercion y actualiza la base de datos, executeUpdate 
               es utilizado para inserciones, actualizaciones y eliminaciones.*/
            numero_registros_db = sentencia_sql.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            try {
                Conexion.close(sentencia_sql);
                Conexion.close(connection);
            } catch (SQLException sql_exception) {
                sql_exception.printStackTrace(System.out);
            }
        }

        return numero_registros_db;
    }

    public void eliminarUsuario(UsuarioDTO usuario) throws SQLException, ClassNotFoundException {
        Conexion conexion = Conexion.obtenerInstancia();
        Connection connection = null;
        PreparedStatement sentencia_sql = null;

        try {
            connection = conexion.getConecction();
            sentencia_sql = connection.prepareStatement(SQL_DELETE);
            sentencia_sql.setString(1, usuario.getName_of_user());
            sentencia_sql.executeUpdate();

        } finally {
            try {
                Conexion.close(sentencia_sql);
                Conexion.close(connection);
            } catch (SQLException sql_exception) {
                sql_exception.printStackTrace(System.out);
            }
        }
    }

    public UsuarioDTO buscarUsuario(String name) throws ClassNotFoundException, SQLException {
        Conexion conexion = Conexion.obtenerInstancia();
        /* Declaracion de los objetos que se implementaran para la consulta de
           base de datos, ya que esta consulta retornara mas de un registro de
           la base de datos es necesario que se emplee una lista de objetos de
           tipo UsuarioDTO */
        Connection connection = null;
        PreparedStatement sentencia_sql = null;
        ResultSet result_consulta = null;
        UsuarioDTO usuario = null;

        try {
            // LLamada a la clase Conexion que nos brindara el objeto tipo conexion.
            connection = conexion.getConecction();
            // Una vez establecida la coneccion nos preparamos para la consulta.
            sentencia_sql = connection.prepareStatement(SQL_SEARCH_USER);
            sentencia_sql.setString(1, name);
            /* Despues de ejecutar la consulta es necesario almacenar los datos 
               obtenidos asi que se los guardamos en un objeto de tipo Reult*/
            result_consulta = sentencia_sql.executeQuery();

            while (result_consulta.next()) {
                String name_of_user = result_consulta.getString("name_of_user");
                String password = result_consulta.getString("password");
                //String type_of_user = result_consulta.getString("type_of_user");
                //String status = result_consulta.getString("status");

                //inicializacion por medio del metodo contructor sobrecargado.
                usuario = new UsuarioDTO(name_of_user, password);

                /* Con cada registro existente se crea y se aniade un objeto de tipo
                   usuario a la lista.*/
                //System.out.print("" + usuario);
            }
        } catch (SQLException sql_exception) {
            sql_exception.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(result_consulta);
                Conexion.close(sentencia_sql);
                Conexion.close(connection);
            } catch (SQLException sql_exception) {
                sql_exception.printStackTrace(System.out);
            }
        }
        return usuario;
    }//Fin cosultarTodosLosMetodos.
}
