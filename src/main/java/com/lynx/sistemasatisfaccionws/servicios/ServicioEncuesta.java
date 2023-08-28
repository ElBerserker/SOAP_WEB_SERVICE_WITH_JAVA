package com.lynx.sistemasatisfaccionws.servicios;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import com.lynx.sistemasatisfaccionws.entidades.UsuarioDTO;

@WebService
public interface ServicioEncuesta {
    @WebMethod
    public String aplicarEncuesta(int nivel_satisfaccion, String comentario, String folio);
    
    @WebMethod
    public String registrarUsuario(String nombre_usuario, String contrasenia_usuario, String tipo_usuario, String estado_usuario);
    
    @WebMethod
    public String acualizarUsuario(String nombre_usuario, String nuevo_nombre ,String contrasenia_usuario, String tipo_usuario, String estado_usuario);
    
    @WebMethod
    public String eliminarUsuario( String nombre_usuario );
    
    @WebMethod
    public List<UsuarioDTO> listarUsuarios();

    @WebMethod
    public int validarCredenciales(String nombre_usuario, String contrasenia_usuario);

    @WebMethod
    public int[] mostrarNivelesDeSatisfaccion();
}
