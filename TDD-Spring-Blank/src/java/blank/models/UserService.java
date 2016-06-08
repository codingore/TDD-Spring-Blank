package blank.models;

import java.util.List;

public interface UserService {

	public void addUser(User u);
	public void updateUser(User u);
	public List<User> listUsers();
	public User getUserByCode(String code);
	public void removeUser(String code);
	public User getUserByEmail(String email);
	
}
