package servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlantillaDAO;
import model.PlantillaVO;
import model.UsuarioDAO;
import model.UsuarioVO;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String email = request.getParameter("inputEmailCA");
		String username = request.getParameter("inputNameCA");
		String password = request.getParameter("inputPasswdCA");
		// ningun campo vacio
		String msg = "";
		//UsuarioVO user = null;
		if ((email!=null) && (username!=null) && (password!=null)) {
			if (!UsuarioDAO.validateUser(email, password)) {
				System.out.println("Inside validateUser");
				UsuarioVO user = UsuarioDAO.registerUser(email, username, password);
				Vector<PlantillaVO> myteam = PlantillaDAO.createMyTeam(email, user.getId_plantilla()); // devuelve la plantilla vacía
				request.getSession().setAttribute("myteam", myteam);
				request.getRequestDispatcher("plantilla.jsp").forward(request, response);
			} else {
				msg = "Error";
				request.getSession().setAttribute("msg",msg);
				request.getRequestDispatcher("authenticate.jsp").forward(request, response);
			}
		} 
		else if (email == null){
			request.setAttribute("Campo 'Email' vacío",msg);
			request.getRequestDispatcher("authenticate.jsp").forward(request, response);
	
		}
		else if (username == null){
			request.setAttribute("Campo 'Name' vacío",msg);
			request.getRequestDispatcher("authenticate.jsp").forward(request, response);
	
		}
		else if (password == null){
			request.setAttribute("Campo 'Password' vacío",msg);
			request.getRequestDispatcher("authenticate.jsp").forward(request, response);
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
