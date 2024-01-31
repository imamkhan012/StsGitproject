package in.imam.Contoller;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.imam.Service.UserService;
import in.imam.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	@PostMapping("/create")
	public ResponseEntity<String> createRegi(@RequestBody User user)
	
	{
	   User userRegistration = service.UserRegistration(user);	
	   System.out.println(userRegistration);
	   return new ResponseEntity<String>("user registration successfully registered",HttpStatus.CREATED);
	   	  
	}
	@PostMapping("/login")
	public ResponseEntity<String>login(@RequestBody User user)
	{
	
		
		boolean loginService = service.loginService(user);
		if(loginService)
		{
			  return new ResponseEntity<>("Login successful", HttpStatus.OK); 
			 
		}
	else {
		return new ResponseEntity<>("login invalid",HttpStatus.BAD_REQUEST);
	}
		
	
	}public UserController() {
		// TODO Auto-generated constructor stub
	}
	@PostMapping("/Pass/{mail}")
	public ResponseEntity<String> changePass(@PathVariable String mail,@RequestBody User user)
	{
		System.out.println("hii");
		boolean changePassword = service.changePassword(user, mail);
		if(changePassword)
		{
			return new ResponseEntity<>("successfull changed password",HttpStatus.OK);
		}
		else
		{
			return new  ResponseEntity<>("something went wrong",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("u")
	public ResponseEntity<String>hii()
	{
	
		System.out.println("bye");
		return new ResponseEntity<>("hii i",HttpStatus.OK);
	}
 

	
}

