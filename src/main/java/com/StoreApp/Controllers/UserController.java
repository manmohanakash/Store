package com.StoreApp.Controllers;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StoreApp.Models.User;
import com.StoreApp.Services.UserService;


@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService UserService;
	
	@RequestMapping(method=RequestMethod.POST,value="/login", produces = "application/json")
	public String loginUser(HttpServletRequest request,@RequestBody User user) throws JSONException {
		
		JSONObject response = new JSONObject();
		
		Optional<User> user_details = UserService.getUserByUserName(user.getUserName());	
		
		if(user_details.isPresent()) {
			if(user_details.get().getPassword().equals(user.getPassword())) {
					session = request.getSession();
					session.setMaxInactiveInterval(10*60);
					response.put("type","success");
					session.setAttribute("UserID", user_details.get().getUserID());
					session.setAttribute("UserEmail", user_details.get().getEmail());
			}
			else{
				response.put("type","fail");
				response.put("message","Invalid Password");
			}
		}
		else {
			response.put("type","fail");
			response.put("message","Username doesnot exist");
		}
		return response.toString();
}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/register", produces = "application/json")
	public String registerUser(HttpServletRequest request,@RequestBody User user) throws JSONException {
		
		JSONObject response = new JSONObject();

		try {
		if(user==null || user.getFirstName().equals("") || user.getFirstName()==null ||
			user.getLastName().equals("") || user.getLastName()==null ||
			user.getEmail().equals("") ||  user.getEmail()==null ||
			user.getUserName().equals("") ||  user.getUserName()==null ||
			user.getPassword().equals("") ||user.getPassword()==null) {	
			response.put("type","fail");
			response.put("message","Cannot leave fields empty");
		}else if(!user.getEmail().matches("^(.+)@(.+)$")) {	
			response.put("type","fail");
			response.put("message","Please enter Valid email");
		}else if(!user.getUserName().matches("^[A-Za-z_][A-Za-z\\d_]*$")) {	
			response.put("type","fail");
			response.put("message","Username should be alphabets");
		}
		else if(UserService.getUserByEmail(user.getEmail()).isPresent()) {
			response.put("type","fail");
			response.put("message","Email already exists");
		}
		else if(UserService.getUserByUserName(user.getUserName()).isPresent()) {
			response.put("type","fail");
			response.put("message","Username already exists");
		}	
		else {
			if(UserService.addUser(user)==null) {
				response.put("type","Fail");
				response.put("message", "Unable to create account");
			}
			else {
				response.put("type","success");
				response.put("message","Account created");
				
			}
		}		
		}catch(NullPointerException e) {
			response.put("type","fail");
		response.put("message","Please fill all fields");};
		return response.toString();
	}
		

	@RequestMapping(value="/logout")
	public String logout(HttpSession session) throws JSONException {
			
		JSONObject response = new JSONObject();
		
		if (null == session.getAttribute("UserID"))  {
			response.put("type","fail");
			response.put("message","Please Login first");
			response.put("action","login");
		}
		else {
			session.invalidate();
			response.put("type","success");
			response.put("message","Logged Out");
			response.put("action","login");			
		}
		return response.toString();		
	}


}
