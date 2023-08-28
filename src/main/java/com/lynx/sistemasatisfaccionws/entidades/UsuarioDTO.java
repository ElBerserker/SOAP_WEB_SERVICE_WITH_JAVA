/* 
 * Autor:  Raul Hernandez Lopez @Neo
 * Email:   freeenergy1975@gmail.com
 * Date: Jueves 20 de Julio del 2023
 */
package com.lynx.sistemasatisfaccionws.entidades;

public class UsuarioDTO {
     //Definicion de los atributos de usuario.
    private int id_user;
    private String name_of_user;
    private String password;
    private String type_of_user;
    private String status;

    public UsuarioDTO(int id_user, String name_of_user, String password, String type_of_user, String status) {
        this.name_of_user = name_of_user;
        this.password = password;
        this.type_of_user = type_of_user;
        this.status = status;
    }

    public UsuarioDTO(String name_of_user, String password, String type_of_user, String status) {
        this.name_of_user = name_of_user;
        this.password = password;
        this.type_of_user = type_of_user;
        this.status = status;
    }

    public UsuarioDTO(String name_of_user, String type_of_user, String status) {
        this.name_of_user = name_of_user;
        this.type_of_user = type_of_user;
        this.status = status;
    }

    public UsuarioDTO(String name_of_user, String password) {
        this.name_of_user = name_of_user;
        this.password = password;
    }

    public UsuarioDTO(String name_of_user) {
        this.name_of_user = name_of_user;
    }
    // Creacion de los Gett y Sett

    public int getId_user() {
        return id_user;
    }

    public String getName_of_user() {
        return name_of_user;
    }

    public void setName_of_user(String name_of_user) {
        this.name_of_user = name_of_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType_of_user() {
        return type_of_user;
    }

    public void setType_of_user(String type_of_user) {
        this.type_of_user = type_of_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{ " 
					 	+ "name = " + name_of_user
                	+ ", type = " + type_of_user
                	+ ", status = " + status 
					 + " }";
    }
}
