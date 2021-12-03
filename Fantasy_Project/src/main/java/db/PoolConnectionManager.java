package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/** * Clasequeabstraelaconexionconla base dedatos. */

public class PoolConnectionManager {
	// Devuelvela conexion, para no tener que abrirla y cerrarla siempre.
	public final static Connection getConnection() {
		System.out.println("PoolConnectionManager.getConnection()");
		try {
			Class.forName("org.postgresql.Driver");
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			DataSource ds = (DataSource) envCtx.lookup("jdbc/nbaDB");

			Connection conn = ds.getConnection();
			//return conn;
			if (conn != null) {
				System.out.println("Connection OK");
			}
			else {
				System.out.println("Connection Failed");	
			}
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Libera la conexion, devolviendola al pool
	public final static void releaseConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}