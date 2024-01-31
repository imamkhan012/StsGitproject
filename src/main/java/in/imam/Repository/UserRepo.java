package in.imam.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.imam.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	
        List<User> findByUserName(String userName);
        List<User> findByPassword(String password);
        List<User> findByEmail(String email);
        
        
	

}
