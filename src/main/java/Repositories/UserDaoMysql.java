
package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.User;

public class UserDaoMysql implements UserDao {
	
	private Connection connection;
	private static String host ="jdbc:sqlserver://yassine.database.windows.net:1433;database=dice-game;user=yassine.elkhantach1@gmail.com@yassine;password=Natacha.2015;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	
	public UserDaoMysql() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public User getUserById(int uid) {
		User user = null;
		ResultSet rs = null;
		PreparedStatement stmt;
		try {
			this.connection = DriverManager.getConnection(host);
			stmt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
			stmt.setInt(1, uid);
			/*get results*/
			rs = stmt.executeQuery();
			while (rs.next()) {
			    user = new User();
			    user.setUid(rs.getInt("id"));
			    user.setFirstName(rs.getString("firstName"));
			    user.setLastName(rs.getString("lastName"));
			    user.setLogin(rs.getString("login"));
			    user.setPassword(rs.getString("password"));
			    user.setBestScore(rs.getInt("bestScore"));			    
			}
			rs.close();
			stmt.close();
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement stmt;
		try {
			this.connection = DriverManager.getConnection(host);
			stmt = connection.prepareStatement("SELECT * FROM users");
			
			/*get results*/
			rs = stmt.executeQuery();
			while (rs.next()) {
			    User user = new User();
			    user.setUid(rs.getInt("id"));
			    user.setFirstName(rs.getString("firstName"));
			    user.setLastName(rs.getString("lastName"));
			    user.setLogin(rs.getString("login"));
			    user.setPassword(rs.getString("password"));
			    user.setBestScore(rs.getInt("bestScore"));		
			    users.add(user);
			}
			rs.close();
			stmt.close();
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User addUser(User user) {
		PreparedStatement stmt;
		try {
			this.connection = DriverManager.getConnection(host);
			stmt = connection.prepareStatement("INSERT INTO users(firstName,lastName,login,password) VALUES (?,?,?,?)");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getLogin());
			stmt.setString(4, user.getPassword());

			/*get results*/
			stmt.executeUpdate();
			stmt.close();
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.login(user.getLogin(), user.getPassword());
	}

	@Override
	public User updateUser(User user) {
		PreparedStatement stmt;
		try {
			this.connection = DriverManager.getConnection(host);
			stmt = connection.prepareStatement("UPDATE users SET firstName = ?, lastName = ?, login = ?, password = ?, bestScore = ? WHERE id = ?");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getLogin());
			stmt.setString(4, user.getPassword());
			stmt.setInt(5, user.getBestScore());
			stmt.setInt(6, user.getUid());

			stmt.executeUpdate();
			stmt.close();
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User deleteUser(int uid) {
		PreparedStatement stmt;
		User user = this.getUserById(uid);
		try {
			this.connection = DriverManager.getConnection(host);
			stmt = connection.prepareStatement("DELETE FROM users WHERE id = ?");
			stmt.setInt(1, uid);

			stmt.executeUpdate();
			stmt.close();
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}



	@Override
	public User login(String login, String pswd) {
		User user = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			this.connection = DriverManager.getConnection(host);
			stmt = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
			stmt.setString(1,login);
			stmt.setString(2,pswd);
			/*get results*/
			rs = stmt.executeQuery();
			while (rs.next()) {
			    user = new User();
			    user.setUid(rs.getInt("id"));
			    user.setFirstName(rs.getString("firstName"));
			    user.setLastName(rs.getString("lastName"));
			    user.setLogin(rs.getString("login"));
			    user.setPassword(rs.getString("password"));
			    user.setBestScore(rs.getInt("bestScore"));			    
			}
			rs.close();
			stmt.close();
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
