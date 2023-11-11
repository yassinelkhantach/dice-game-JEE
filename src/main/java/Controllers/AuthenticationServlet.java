package Controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.ConfigProperty;

import Entities.User;
import Repositories.UserDaoMysql;
import Services.UserService;
import Services.UserServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.service = new UserServiceImp(new UserDaoMysql());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("isLogged") != null && 
		Boolean.parseBoolean(request.getSession().getAttribute("isLogged").toString())) {
			request.getSession().setAttribute("rounds", new HashMap<>());
			request.getRequestDispatcher("/WEB-INF/Views/index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = service.login(request.getParameter("login"), request.getParameter("password"));
		if(user != null) {
			request.getSession().setAttribute("isLogged", true);
			request.getSession().setAttribute("loggedUser", user);			
		}
		doGet(request, response);
	}

}
