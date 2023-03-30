package Repositories;

import java.util.List;

import Entities.User;

public interface UserDao {
	public User getUserById(int uid);
	public List<User> getAllUsers();
	public User addUser(User user);
	public User updateUser(User user);
	public User deleteUser(int uid);
	public User login(String login, String password);

}
