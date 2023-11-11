<%@page import="Entities.User"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dice Game | Score</title>
	<link href="<%=request.getContextPath()%>/styles/index.css" rel="stylesheet">
</head>
<body>

	<div class="topnav">
	    <section>
		    <a class="active" href="<%=request.getContextPath()%>/game">Game</a>
		  	<a href="<%=request.getContextPath()%>/leaderboard">Leaderboard</a>
		  	<a href="#about">About</a>
	    </section>
		
		<section>
			<form action="game" method="post">
				<input type="hidden" name="logout">
			    <input type="submit" value="Logout" class="logout">
	    	</form>
		</section>
	</div>
	
	<section class="container">
	
		<h1>Welcome to Dice Game Dashboard</h1>
		
		<div class="game-over">
			<h2>Game Over</h2>
						
			<h3>Your current score is : <%=request.getSession().getAttribute("score") %></h3>
			<h3>Your best score is : <%=((User)request.getSession().getAttribute("loggedUser")).getBestScore()%></h3>
		</div>
		
		<div class="dices">
	  		<%
	  		for(Entry<Integer,Integer> entry : ((HashMap<Integer, Integer>)request.getSession().getAttribute("rounds")).entrySet()){
	  		%>
	  		  <img alt="" src="<%=request.getContextPath()%>/assets/dice-<%=((HashMap<Integer, String>)request.getSession().getAttribute("dices")).get(entry.getValue())%>-solid.svg" style="height:100px;">
	  		<%
	  		}
	  		%>
	  	</div>
	  	
	  	<div class="restart">
	  		<a href="<%=request.getContextPath()%>/game" autofocus>Restart</a>
	  	</div>
	  	  	
  	</section>
</body>
</html>