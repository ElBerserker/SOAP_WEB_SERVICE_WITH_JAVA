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

public class EncuestaDAO {
    private static final String SQL_GET_LEVEL_SATISFACTION = "CALL obtenerNivelesDeSatisfaccion()";
    private static final String SQL_SELECT = "SELECT * FROM satisfaction_survey";
    private static final String SQL_INSERT = "INSERT INTO satisfaction_survey(level_of_satisfaction, coment, folio_ticket) VALUES (?, ?, ?)";
    
    public List<EncuestaDTO> consutarEncuestas() throws ClassNotFoundException{
        Connection conexion = null;
        PreparedStatement sentencia_sql = null;
        ResultSet result = null;
        EncuestaDTO encuesta = null;
        List<EncuestaDTO> encuestas = new ArrayList<>();
        
        try{
            conexion = Conexion.getConnection();
            sentencia_sql = conexion.prepareStatement(SQL_SELECT);
            result = sentencia_sql.executeQuery();
            
            while(result.next()){
                int nivel_satisfaccion  =  result.getInt("level_of_satisfaction");
                String comentario = result.getString("coment");
                String folio = result.getString("folio_ticket");
                String fecha = result.getString("date_and_time");
                
                encuesta = new EncuestaDTO(nivel_satisfaccion, comentario, folio, fecha);
                
                encuestas.add(encuesta);
            }
        }catch(SQLException sql_exception){
            sql_exception.printStackTrace(System.out);
        }finally{
            try{
                Conexion.close(result);
                Conexion.close(sentencia_sql);
                Conexion.close(conexion);
            }catch(SQLException sql_exception){
                sql_exception.printStackTrace(System.out);
            }
        }
        return encuestas;
    }
    
    public void InsertarEncuesta(EncuestaDTO encuesta) {
        Connection conexion = null;
        PreparedStatement sentencia_sql = null;
        int numero_registro = 0;
        
        try{
            conexion = Conexion.getConnection();
            sentencia_sql = conexion.prepareStatement(SQL_INSERT);
            
            sentencia_sql.setInt(1, encuesta.getNivel_satisfaccion());
            sentencia_sql.setString(2, encuesta.getComentario());
            sentencia_sql.setString(3, encuesta.getFolio());
            
            numero_registro = sentencia_sql.executeUpdate();
            
        }catch(SQLException sql_exception){
            sql_exception.printStackTrace(System.out);
        }catch(ClassNotFoundException class_not_found){
            class_not_found.printStackTrace(System.out);
        }finally{
            try{
                Conexion.close(sentencia_sql);
                Conexion.close(conexion);
            }catch(SQLException sql_Exception){
                sql_Exception.printStackTrace(System.out);
            }
        }
    }

	 public int[]  obtenerNivelesDeSatisfaccion() throws ClassNotFoundException{
	 	int nivelesDeSatisfaccion[] = new int[3];
		int iterador = 0;;

		Connection conexion = null;
		PreparedStatement sentencia_sql = null;
		ResultSet result_consulta = null;

		try{
			conexion = Conexion.getConnection();
			sentencia_sql = conexion.prepareStatement(SQL_GET_LEVEL_SATISFACTION);
			result_consulta = sentencia_sql.executeQuery();

			while(result_consulta.next()){
				 nivelesDeSatisfaccion[iterador] = result_consulta.getInt(1);
				 System.out.print("" + nivelesDeSatisfaccion[iterador] + "\n");
				 iterador++;
			}
		}catch(SQLException ex){
			ex.printStackTrace(System.out);
		}finally{
			try{
				Conexion.close(result_consulta);
				Conexion.close(sentencia_sql);
				Conexion.close(conexion);
			}catch(SQLException ex){
				ex.printStackTrace(System.out);
			}
		
		}
		return nivelesDeSatisfaccion;
	 }
}
