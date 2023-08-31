package com.lynx.sistemasatisfaccionws.servicios;

import com.lynx.sistemasatisfaccionws.entidades.UsuarioDTO;
import com.lynx.sistemasatisfaccionws.entidades.UsuarioDAO;
import com.lynx.sistemasatisfaccionws.entidades.EncuestaDTO;
import com.lynx.sistemasatisfaccionws.entidades.EncuestaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    public static void main(String args[]) throws InstantiationException, IllegalAccessException, SQLException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        EncuestaDAO encuestaDAO = new EncuestaDAO();
        //######################################################################    
        //insercion de un objeto de la base de datos
        
        //EncuestaDTO nueva_encuesta =  new EncuestaDTO(2, "prueba 1", "F1");
        //encuestaDAO.InsertarEncuesta(nueva_encuesta);
		  
        /*UsuarioDTO nuevo_usuario = new UsuarioDTO("UsrJava", "JAVA", "STANDAR", "ACTIVE");
        usuarioDAO.InsertarUsuario(nuevo_usuario);*/
         
        //######################################################################    
            
        /*UsuarioDTO eliminar_usuario = new UsuarioDTO("u13");
          usuarioDAO.eliminarUsuario(eliminar_usuario);*/
        
        //######################################################################        
        //UsuarioDTO actualizar_usuario = new UsuarioDTO("ACT", "ACT", "ACT", "ACTIVE");
        //usuarioDAO.actualizarUsuario(actualizar_usuario, "UsrJava");
        //######################################################################
        
        try {
            // Declaracion y definicion de la lista de usuarios.
            List<UsuarioDTO> usuarios = usuarioDAO.consultarTodosLosUsuarios();
            // Impresion de resultados por consola.
            for(UsuarioDTO usuario: usuarios){
                System.out.print("\n" + usuario + ")");
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // Declaracion y definicion de la lista de encuestas.
            List<EncuestaDTO> encuestas = encuestaDAO.consutarEncuestas();
            // Impresion de resultados por consola.
            for(EncuestaDTO encuesta: encuestas){
                System.out.print("\n" + encuesta + ")");
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
