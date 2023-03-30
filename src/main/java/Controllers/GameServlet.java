package Controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<Integer,String> dices = new HashMap<>(){{
		put(1, "one");
		put(2, "two");
		put(3, "three");
		put(4, "four");
		put(5, "five");
		put(6, "six");
	}};

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("dices", this.dices);
		if(request.getSession().getAttribute("isLogged") != null && 
		Boolean.parseBoolean(request.getSession().getAttribute("isLogged").toString())) {

			if(request.getSession().getAttribute("rounds") == null){
				request.getSession().setAttribute("rounds", new HashMap<>());
				request.getRequestDispatcher("/WEB-INF/Views/index.jsp").forward(request, response);
			}else 
			if(request.getSession().getAttribute("score") != null && getUserRoundsFromSession(request) != null){
				request.getRequestDispatcher("/WEB-INF/Views/score.jsp").forward(request, response);
				request.getSession().removeAttribute("score");
				request.getSession().removeAttribute("rounds");
			}else {
				request.getRequestDispatcher("/WEB-INF/Views/index.jsp").forward(request, response);
			}
				
		}else {
			request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("logout") != null) {
			request.getSession().removeAttribute("loggedUser");
			request.getSession().removeAttribute("isLogged");
			request.getSession().removeAttribute("rounds");
			doGet(request, response);
		}
		
		
		if(request.getParameter("game") != null) {
			Integer round = Integer.parseInt(request.getParameter("diceNumber")); 
			HashMap<Integer, Integer> rounds = getUserRoundsFromSession(request);
			Integer randint = new Random().nextInt(6)+1;

			System.out.println(randint);
			
			if(getUserRoundsFromSession(request) != null && getUserRoundsFromSession(request).size() <3 ) {
				if(getUserRoundsFromSession(request).containsKey(round)) {
				
					request.getSession().setAttribute("score", -1);
				}
				
				rounds.put(round, randint);
				request.getSession().setAttribute("rounds",rounds);
				
				if(getUserRoundsFromSession(request) != null && getUserRoundsFromSession(request).size() == 2) {
					if((getUserRoundsFromSession(request).get(1) == Integer.valueOf(5) && getUserRoundsFromSession(request).get(2) == Integer.valueOf(6) ) || 
						(getUserRoundsFromSession(request).get(1) == Integer.valueOf(2) && getUserRoundsFromSession(request).get(2) == Integer.valueOf(1) )) {
						
						request.getSession().setAttribute("score", 0);
					}
				}
				
				if(getUserRoundsFromSession(request) != null && getUserRoundsFromSession(request).size() == 3) {
					if((getUserRoundsFromSession(request).get(1) > getUserRoundsFromSession(request).get(2)) && 
						(getUserRoundsFromSession(request).get(2) > getUserRoundsFromSession(request).get(3))) {
						System.out.println("Message 3");
							request.getSession().setAttribute("score", multiplication(rounds));
							
					}else
					if((getUserRoundsFromSession(request).get(1) < getUserRoundsFromSession(request).get(2)) && 
						(getUserRoundsFromSession(request).get(2) < getUserRoundsFromSession(request).get(3))) {
						request.getSession().setAttribute("score", sum(rounds));
					}else {
						request.getSession().setAttribute("score", 0);
						
					}
				}

			}else {
				System.out.println(getUserRoundsFromSession(request));
			}

		}
		
		doGet(request, response);

	}
	
	@SuppressWarnings("unchecked")
	private HashMap<Integer, Integer> getUserRoundsFromSession(HttpServletRequest request){
		return ((HashMap<Integer, Integer>)request.getSession().getAttribute("rounds"));
	}

	private Integer sum(HashMap<Integer, Integer> rounds) {
		Integer sum = 0;
		for(Integer round : rounds.values())
			sum += round;
		return sum;
	}
	
	private Integer multiplication(HashMap<Integer, Integer> rounds) {
		Integer result = 1;
		for(Integer round : rounds.values())
			result *= round;
		return result;
	}
}
