package in.imam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import in.imam.Repository.UserRepo;
import in.imam.model.User;

@Service
public class UserServiceImpl implements UserService{

@Autowired
private UserRepo repo;

	@Override
	public User UserRegistration(User user) {
		 
		return repo.save(user);
	}

	@Override
	public boolean loginService(User user) {
		// TODO Auto-generated method stub
		boolean i=false;
	    String userName = user.getUserName();
	    String password = user.getPassword();
	    List<User> findByUserName = repo.findByUserName(userName);
	    List<User> findByPassword = repo.findByPassword(password);
	    if(findByUserName.size()>0 && findByPassword.size()>0)
	    {
	    	i=true;
	    }
	    return i;
	   
	
	}

	@Override
	public boolean changePassword( User user,String mail) {
		// TODO Auto-generated method stub
		boolean isChanged=false;
		List<User> findByEmail = repo.findByEmail(mail);
		if(findByEmail.size()>0)
		{
			User user2 = findByEmail.get(0);
			user2.setPassword(user.getPassword());
			repo.save(user2);
			isChanged=true;
			
		}
		return isChanged;
	}
	

	

}
