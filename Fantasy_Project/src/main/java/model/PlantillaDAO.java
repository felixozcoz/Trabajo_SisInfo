package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.Vector;

import db.PoolConnectionManager; // package que contiene implementada la función PoolConnectionManager

public class PlantillaDAO {
	private static String listMyTeam = "SELECT JP.nombre,E.camImag FROM((Plantilla P JOIN Jugador J ON J.id_jugador=P.id_jugador AND P.id_plantilla = ?) JP JOIN Equipo E ON JP.equipo=E.id)";
	private static String updatePlayer = "UPDATE Plantilla SET id_jugador=? WHERE id_plantilla=? AND id_orden=?";
	private static String createNewTeam = "INSERT INTO Plantilla (id_plantilla,id_orden,id_jugador) VALUES (?,1,1),(?,2,2),(?,3,3),(?,4,4),(?,5,5),(?,6,6),(?,7,7),(?,8,8),(?,9,9),(?,10,10)";
	private static String findByEmail = "SELECT * FROM Usuario WHERE Email = ?";
	/*
	 *	READ OPERATION
	 *	Devuelve el listado de todos los jugadores que componen la plantilla
	 *	del usuario que tiene como identificador de plantilla, 'userId_plantilla'
	 */ 
	public static Vector<PlantillaVO> getMyTeam(String email){
		Vector<PlantillaVO> myteam = new Vector<>();
		Connection conn = null;

		
		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement findPs = conn.prepareStatement(findByEmail);
			PreparedStatement plantPs = conn.prepareStatement(listMyTeam); // Cada jugador y la camiseta  que le corresponde
			findPs.setString(1, email);
			// finding user's id_plantilla
			ResultSet findRs = findPs.executeQuery();
			findRs.next();
			String idPlant = findRs.getString("id_plantilla");
			// finding my team
			plantPs.setInt(1, Integer.valueOf(idPlant));

			ResultSet rset = plantPs.executeQuery();
			
			for(;rset.next();){
				myteam.add( new PlantillaVO(Integer.valueOf(idPlant), rset.getString("Nombre"), rset.getString("camImag")));
			}
			
			// Cerrando recursos
			findPs.close();
			findRs.close();
			plantPs.close();
			rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return myteam;
	}


	/*
	 *	WRITE OPERATION
	 *	Ha actualizado la plantilla identificada por el valor de 'userID_plantilla',
	 *	y se ha sutituido el jugador en el orden 'id_orden', por el jugador con
	 *  identificador 'id_jugador'
	 */
	public void addPlayer(int userId_plantilla, int id_orden, int id_jugador){
		Connection conn = null;

		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(updatePlayer);
			// Asignar variables de la query
			ps.setString(1,String.valueOf(id_jugador));
			ps.setString(2,String.valueOf(userId_plantilla));
			ps.setString(3,String.valueOf(id_orden));
			
			ResultSet rset = ps.executeQuery();
			rset.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
	}


	/*
	 *	WRITE OPERATION
	 *	Ha actualizado la plantilla identificada por el valor de 'userID_plantilla',
	 *	y se ha sutituido el jugador en 'id_orden' por el valor null 
	 */
	public void removePlayer(int userId_plantilla, int id_orden){
		Connection conn = null;

		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(updatePlayer);
			// Asignar variables de la query
			ps.setString(1,"null");
			ps.setString(2,String.valueOf(userId_plantilla));
			ps.setString(3,String.valueOf(id_orden));
			
			ResultSet rset = ps.executeQuery();
			rset.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
	}



	/*
	 *	WRITE OPEARTION:  Crear plantilla vacía (los id_jugador = null)
	 */
	public static Vector<PlantillaVO> createMyTeam(String email, String userId_plantilla){
		Connection conn = null;
		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement createPs = conn.prepareStatement(createNewTeam);
			// Asignar variables de la query
			int id = Integer.valueOf(userId_plantilla);
			createPs.setInt(1,id);
			createPs.setInt(2,id);
			createPs.setInt(3,id);
			createPs.setInt(4,id);
			createPs.setInt(5,id);
			createPs.setInt(6,id);
			createPs.setInt(7,id);
			createPs.setInt(8,id);
			createPs.setInt(9,id);
			createPs.setInt(10,id);
			// Inserta la nueva plantilla vacía
			int a = createPs.executeUpdate();
			if (a == 0) {
				System.out.println("Error: insert new team");
				return null;
			}
			createPs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return getMyTeam(email); // recupera la plantilla totalmente vacía
	}
}