package Services;

import java.util.List;

import Entities.User;
import Repositories.UserDao;

public class UserServiceImp implements UserService {

	private UserDao dao;
	
	public UserServiceImp(UserDao dao) {
		this.dao = dao;
	} 
	
	
	@Override
	public User getUserById(int uid) {
		return dao.getUserById(uid);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public User addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public User deleteUser(int uid) {
		return dao.deleteUser(uid);
	}


	@Override
	public User login(String login, String password) {
		return dao.login(login, password);
	}

}
