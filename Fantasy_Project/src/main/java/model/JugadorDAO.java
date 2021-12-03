package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import db.PoolConnectionManager; // package que contiene implementada la función PoolConnectionManager
//import model.JugadorVO;


public class JugadorDAO {
	private static String basicStatsPlayer = "SELECT J.nombre, J.posicion, J.equipo, J.puntos, J.precio, J.pj, J.media, E.camImag, E.equipoImag FROM(Jugador J JOIN Equipo E ON J.equipo=E.id AND J.nombre=?)";
	//private static String searchBy = "SELECT * FROM Jugador WHERE Jugador.? = ?";

	/*
	 *	READ OPERATION
	 *	PRE: typeSearchParameter almacena la secuencia de tipos de parámetros que el usuario ha buscado
	 *		 La cantidad de filtros para la búsqueda puede variar de 1 a 3, y son los siguientes: posición,precio de mercado y equipo.
	 *		 Los parámetros de búsqueda son siempre en el orden antes mencionado.
	 *		 parameters almacena la secuencia de parámetros a buscar.
	 *	POST: Ha devuelto todos los jugadores que cumplen con los filtro de búsqueda que se han aplicado
	 *
	 */
	public static Vector<JugadorVO> infoPlayersByName(Vector<String> playersName){
		Connection conn = null;
        Vector<JugadorVO> playersInfo = new Vector<>();

		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(basicStatsPlayer);
			int size = playersName.size();
			for(int i = 0 ; i < size ; i++) {
				ps.setString(1, playersName.get(i));
				ResultSet rset = ps.executeQuery();
				rset.next();
				playersInfo.add(new JugadorVO(playersName.get(i), 
						rset.getString("posicion"), 
						rset.getString("equipo"), 
						rset.getInt("puntos"), 
						rset.getLong("precio"), 
						rset.getInt("pj"), 
						rset.getFloat("media"),
						rset.getString("camImag"),
						rset.getString("equipoImag")));
				rset.close();
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return playersInfo;
	}
}