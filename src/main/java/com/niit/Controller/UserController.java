package com.niit.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.Services.UserDAO;
import com.niit.model.User;

@Controller
public class UserController {
	
	
@Autowired
private UserDAO userDAO;


public UserDAO getUserDAO() {
	return userDAO;
}

public void setUserDAO(UserDAO userDAO) {
	this.userDAO = userDAO;
}

/*@RequestMapping(value="/login",method=RequestMethod.POST)
public ResponseEntity<?> login(@RequestBody User user){
	logger.debug("Entering USERCONTROLLER : LOGIN");
	User validUser=userDAO.authenticate(user);
	if(validUser==null){
		logger.debug("validUser is null");
		Error error=new Error(1,"Username and password doesnt exists...");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED); 
	}
	else{
		validUser.setOnline(true);
		userDAO.updateUser(validUser); 
		logger.debug("validUser is not null");
		return new ResponseEntity<User>(validUser,HttpStatus.OK);
	}
}*/

/*@RequestMapping(value="/register",method=RequestMethod.POST)
public ResponseEntity<?> registerUser(@RequestBody User user){
	
	try{
	logger.debug("USERCONTROLLER=>REGISTER " + user);
	user.setStatus(true);
	user.setOnline(false);
	User savedUser=userDAO.authenticate(user);
	logger.debug("User Id generated is " + savedUser.getUserid());
	if(savedUser.getUserid()==0){
		Error error=new Error(2,"Couldnt insert user details ");
		return new ResponseEntity<Error>(error , HttpStatus.CONFLICT);
	}
	else
		return new ResponseEntity<User>(savedUser,HttpStatus.OK);
	}catch(Exception e){
		e.printStackTrace();
		Error error=new Error(2,"Couldnt insert user details. Cannot have null/duplicate values " + e.getMessage());
		return new ResponseEntity<Error>(error , HttpStatus.INTERNAL_SERVER_ERROR);
	}
}*/
@RequestMapping(value="user",method=RequestMethod.GET)
public  ResponseEntity<List<User>> getAllUsers(){
	System.out.println(userDAO.getAllUsers());
	List<User> persons=userDAO.getAllUsers();
	if(persons.isEmpty())
		return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	return new ResponseEntity<List<User>>(persons,HttpStatus.OK);
}


@RequestMapping(value="user/{id}",method=RequestMethod.GET)
public ResponseEntity<User> getUserById(@PathVariable(value="id") int id){
	User user=userDAO.getUser(id);
	if(user==null)
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<User>(user,HttpStatus.OK);
}

@RequestMapping(value="user",method=RequestMethod.POST)

public ResponseEntity createUser(@RequestBody User user, UriComponentsBuilder build)
{
	userDAO.insertUser(user);
	HttpHeaders headers=new HttpHeaders();
	
	URI urilocation=
			build.path("user/")
			.path(String.valueOf(user.getUserid()))
			.build()
			.toUri();
	headers.setLocation(urilocation);
	return new ResponseEntity(headers,HttpStatus.CREATED);
}


@RequestMapping(value="user/{id}",method=RequestMethod.PUT)
public ResponseEntity<User> updateUser(
		@PathVariable int id,@RequestBody User user){
	
	User updatedUser=userDAO.updateUser(id, user);
	if(user==null)
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	userDAO.updateUser(id, user);
	return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	
	
}
@RequestMapping(value="user/{id}",method=RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable int id){
	User user=userDAO.getUser(id);
	if(user==null)
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	userDAO.deleteUser(id);
	return new ResponseEntity<Void>(HttpStatus.OK);
}


}





