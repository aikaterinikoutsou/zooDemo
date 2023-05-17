package zooDemaIfaces;

import java.util.List;

import zooDemoPOJO.Role;
import zooDemoPOJO.User;

public interface UserManager {

	
	public void disconnect();
	public void newUser(User u);
	public void newRole(Role r);
	
	public Role getRole(Integer id);
	
	public List<Role> getRoles();
	
	public User checkPassword(String email, String passwd);
}
