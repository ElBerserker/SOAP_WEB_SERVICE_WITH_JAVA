/*
 * Autor: Raul Hernandez  Lopez @NEO
 * Correo:  freeenergy1975@gmail.com 
 * Fecha: Jueves 27 de Julio de 2023
 * */

package com.lynx.sistemasatisfaccionws.funciones;

import com.lynx.sistemasatisfaccionws.entidades.UsuarioDTO;
import com.lynx.sistemasatisfaccionws.entidades.UsuarioDAO;
import java.sql.SQLException;

public class FuncionesUsuario{
   //Este metodo de validacion retona un 1 si las credenciales de acceso son validas y un 0 si no.
 	public int validarAcceso(String name_of_user, String password) throws ClassNotFoundException, SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioDTO usuarioDTO = null;
			
		usuarioDTO = usuarioDAO.buscarUsuario(name_of_user);
		
		if( usuarioDTO != null ){
			if( password.equals(usuarioDTO.getPassword()) ){
				System.out.print("\nAcceso concedido\n");
				return 1;
			}else{
				System.out.print("\nAcceso denegado\n");
				return 2;
			}
		}else{
			System.out.print("Usuario no encontrado");
			return 3;
		}
	}
}
