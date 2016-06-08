package blank.models;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void addUser(User u) {
		this.userDAO.addUser(u);
	}

	@Override
	public void updateUser(User u) {
		this.userDAO.updateUser(u);
	}

	@Override
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	public User getUserByCode(String code) {
		return this.userDAO.getUserByCode(code);
	}

	@Override
	public void removeUser(String code) {
		this.userDAO.removeUser(code);
	}

	@Override
	public User getUserByEmail(String email) {
		return this.userDAO.getUserByEmail(email);
	}

}
