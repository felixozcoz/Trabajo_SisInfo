package model;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.PoolConnectionManager; // package que contiene implementada la función PoolConnectionManager


public class EquipoDAO {
	private static String basic = "SELECT nombre FROM Equipo WHERE id='CHI'";

	/*
	 *	READ OPERATION
	 *	PRE: 
	 *	POST: 
	 *
	 */
	public static String teamName(){
		System.out.println("Funcion teamName() funcionando\n");
		Connection conn = null;
        String name;

		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(basic);

			ResultSet rset = ps.executeQuery();
			//rset.next();
			//System.out.println(rset);
			rset.next();
			//System.out.println(rset);
			name = rset.getString("nombre");

		} catch (Exception e) {
			e.printStackTrace();
			name = "empty";
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return name;
	}
}