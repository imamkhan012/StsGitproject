package in.imam.Service;

import in.imam.model.User;

public interface UserService {
	
	public User UserRegistration(User user);
	public boolean loginService(User user);
	public boolean changePassword(User user,String mail);

}
