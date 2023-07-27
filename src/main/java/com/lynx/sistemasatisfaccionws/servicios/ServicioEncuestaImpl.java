// Autor: Raul Hernandez Lopez @Neo
// Correo: freeenergy1975@gmail.com
// Fecha: 29 de Enero del 2023
package com.lynx.sistemasatisfaccionws.servicios;

import com.lynx.sistemasatisfaccionws.entidades.EncuestaDTO;
import com.lynx.sistemasatisfaccionws.entidades.EncuestaDAO;
import com.lynx.sistemasatisfaccionws.entidades.UsuarioDTO;
import com.lynx.sistemasatisfaccionws.entidades.UsuarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "com.lynx.sistemasatisfaccionws.servicios.ServicioEncuesta")
public class ServicioEncuestaImpl implements ServicioEncuesta {

    @Override
    public String aplicarEncuesta(int nivel_satisfaccion, String comentario, String folio) {
        EncuestaDAO encuestaDAO = new EncuestaDAO();
        EncuestaDTO nueva_encuesta = new EncuestaDTO(nivel_satisfaccion, comentario, folio);
        try {
            encuestaDAO.InsertarEncuesta(nueva_encuesta);
        } catch (Exception e) {
            System.out.print("Error : " + e + " Fin#");
            System.out.print("Error : " + e.getCause() + " Fin#");
        }
        return "" + nueva_encuesta;
    }

    @Override
    public String registrarUsuario(String nombre_usuario, String contrasenia_usuario, String tipo_usuario, String estado_usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioDTO nuevo_usuario = new UsuarioDTO(nombre_usuario, contrasenia_usuario, tipo_usuario, estado_usuario);
        try {
            usuarioDAO.InsertarUsuario(nuevo_usuario);
        } catch (Exception e) {
            System.out.print("Error : " + e + " Fin#");
            System.out.print("Error : " + e.getCause() + " Fin#");
        }
        return "" + nuevo_usuario;
    }

    @Override
    public String acualizarUsuario(String nombre_usuario, String nuevo_nombre,String contrasenia_usuario, String tipo_usuario, String estado_usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioDTO usuario_actualizado = new UsuarioDTO(nuevo_nombre, contrasenia_usuario, tipo_usuario, estado_usuario);

        usuarioDAO.actualizarUsuario(usuario_actualizado, nombre_usuario);
        
        return "" + usuario_actualizado;
    }

    @Override
    public String eliminarUsuario(String nombre_usuario){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioDTO usuario_eliminado = new UsuarioDTO(nombre_usuario);

        usuarioDAO.eliminarUsuario(usuario_eliminado);
        return "" + usuario_eliminado;
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<UsuarioDTO> usuarios = null;
        
        try {
            usuarios = usuarioDAO.consultarTodosLosUsuarios();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioEncuestaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
}
