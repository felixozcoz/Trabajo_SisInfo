package servlet;

import java.io.IOException;
//import java.io.StringWriter;
//import java.io.Writer;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
//import com.google.gson.JsonElement;

import model.JugadorDAO;
import model.JugadorVO;


//import javax.json.Json;
//import javax.json.JsonObject;
//import javax.json.JsonArray;
//import javax.json.JsonValue;
//import javax.json.JsonWriter;
//import javax.json.JsonObjectBuilder;
//import org.json.simple.JsonObject;



/**
 * Servlet implementation class adHoc
 */
@WebServlet("/adHoc")
public class adHoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adHoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//JsonArray array = Json.createArrayBuilder().build();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// Extracción de parámetros: nombres de los cuatro jugadores del banquillo
		Vector<String> playersName = new Vector<>();
		playersName.add(request.getParameter("player6"));
		playersName.add(request.getParameter("player7"));
		playersName.add(request.getParameter("player8"));
		playersName.add(request.getParameter("player9"));
		playersName.add(request.getParameter("player10"));
		// posicion, equipo, nombre, precio, puntos
		Vector<JugadorVO> infoPlayers = JugadorDAO.infoPlayersByName(playersName); // devuleve Vector<JugadorVO> con todos los stats de los jugadores solicitados
		
		Gson gson = new Gson();
		//System.out.println("json="+json);
		String json = "";
		try {
			json = gson.toJson(infoPlayers);
			response.getWriter().write(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("Failure");
		}
		System.out.println("Llega al final de adHoc");

		
		 
		 
		/*
		 String text = "some text";

		 response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		 response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		 response.getWriter().write(text);       // Write response body.
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
