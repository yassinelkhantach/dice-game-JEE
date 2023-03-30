package Controllers;

import java.io.IOException;

import Entities.User;
import Repositories.UserDaoMysql;
import Services.UserServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserServiceImp service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.service = new UserServiceImp(new UserDaoMysql());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("isLogged") != null && 
		Boolean.parseBoolean(request.getSession().getAttribute("isLogged").toString())) {
			request.getRequestDispatcher("/WEB-INF/Views/index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/Views/register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		
		if(service.addUser(user) != null){
			request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
