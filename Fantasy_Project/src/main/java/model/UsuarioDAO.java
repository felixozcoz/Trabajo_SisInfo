package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.PoolConnectionManager;

public class UsuarioDAO {
		//private static String countByUserEmail = "SELECT count(*) cuentas FROM Usuario WHERE email = ?";
		private static String findByEmail = "SELECT * FROM Usuario WHERE Email = ?";
		private static String registerNewUser = "INSERT INTO Usuario (email,username,password) VALUES (?,?,?)";
		
		/** * Busca un registro en la tabla DEMO por ID * 
			@param id Identificador del registro buscado * 
			@returnObjeto DemoVO con el identificador buscado, o null si no seencuentra 
		*/
		public static boolean validateUser(String email, String password) { 
			boolean result = false;
			Connection conn = null;
			
			try {
				// Abrimos la conexión e inicializamos los parámetros 
				conn = PoolConnectionManager.getConnection(); 
				PreparedStatement findPs = conn.prepareStatement(findByEmail);
				findPs.setString(1,email);
				
				// Ejecutamos la consulta 
				ResultSet findRs = findPs.executeQuery();
				
				// Leemos resultados 
				// Comparamos contraseñas
				findRs.next();
				String dbpwd = findRs.getString("password");
				if (dbpwd != null) {
					if (dbpwd.contentEquals(password)) {
						result = true;
					} 
					else { 
						result = false;  
					} 
				}
				// liberamos los recursos utilizados
				findRs.close();
				findPs.close();

			} catch(SQLException se) {
				se.printStackTrace();  
			
			} catch(Exception e) {
				e.printStackTrace(System.err); 
			} finally {
				PoolConnectionManager.releaseConnection(conn); 
			}
			return result;
		}
			
		
		public static UsuarioVO getUserByUsername(String username) {
			Connection conn = null;
			UsuarioVO user = null;

			try {
				// Abrimos la conexión e inicializamos los parámetros 
				conn = PoolConnectionManager.getConnection(); 
				PreparedStatement ps = conn.prepareStatement("Select * from Usuario where nombre= ?");
				ps.setString(1, username);
				ResultSet rset = ps.executeQuery();
				rset.next();
				user = new UsuarioVO(rset.getString("email"),rset.getString("nombre"), rset.getString("passwd"),rset.getString("id_plantilla"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				PoolConnectionManager.releaseConnection(conn);
			}
			return user;
		}
		
		public static UsuarioVO registerUser(String email, String username, String password) { 
			Connection conn = null;
			UsuarioVO user = null;
			
			try {
				// Abrimos la conexión e inicializamos los parámetros 
				conn = PoolConnectionManager.getConnection(); 
				PreparedStatement registerPs = conn.prepareStatement(registerNewUser);
				PreparedStatement findPs = conn.prepareStatement(findByEmail);
				registerPs.setString(1, email);
				registerPs.setString(2, username);
				registerPs.setString(3, password);
				findPs.setString(1, email);

				int OK = registerPs.executeUpdate(); // tipo de execute para INSERT,DELETE y UPDATE
				if (OK == 1) { // ninguna fila fue actualizada, por lo que hubo algún problema
						ResultSet rset = findPs.executeQuery();
						rset.next();
						user = new UsuarioVO(email,password, username, rset.getString("id_plantilla"));
						rset.close();
				}
				// liberamos los recursos utilizados
				registerPs.close();
				findPs.close();
			} catch(SQLException se) {
				se.printStackTrace();  
			
			} catch(Exception e) {
				e.printStackTrace(System.err); 
			} finally {
				PoolConnectionManager.releaseConnection(conn); 
			}
			return user;
		}
}
