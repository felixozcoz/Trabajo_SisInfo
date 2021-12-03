package servlet;

import java.io.IOException;
import java.util.Vector;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;

//import model.JugadorVO;
import model.PlantillaDAO;
import model.PlantillaVO;
import model.UsuarioDAO;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("application/json");
		//response.setCharacterEncoding("UTF-8");
		String email = request.getParameter("inputEmailNameSI");
		String password = request.getParameter("inputPasswordSI");
		
		//Gson gson = new Gson();
		//String json = "klk";
		
		try {
			if (UsuarioDAO.validateUser(email, password)) { // OK
				Vector<PlantillaVO> myteam = PlantillaDAO.getMyTeam(email);
				//json = gson.toJson(myteam);
				//response.getWriter().write(json);
				request.getSession().setAttribute("myteam",myteam); 
				request.getRequestDispatcher("plantilla.jsp").forward(request, response);
			}
			else {
				String msg="";
				request.setAttribute("Autenticación inválida", msg);
				request.getRequestDispatcher("authenticate.jsp").forward(request,response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
