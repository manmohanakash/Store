package com.StoreApp.Controllers;


import java.util.Date;
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

import com.StoreApp.Models.Customer;
import com.StoreApp.Models.User;
import com.StoreApp.Services.CustomerService;
import com.StoreApp.Services.UserService;


@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService UserService;
	
	
	@Autowired
	private CustomerService CustomerService;
	
	@RequestMapping(method=RequestMethod.POST,value="/login", produces = "application/json")
	public String loginUser(HttpServletRequest request,@RequestBody User user) throws JSONException {
		
		JSONObject response = new JSONObject();
		
		Optional<User> currentUser = UserService.getUserByUserName(user.getUserName());	
		
		if(currentUser.isPresent()) {
			
			User loggedUser = currentUser.get();
			
			if(loggedUser.getPassword().equals(user.getPassword())) {
					
				loggedUser.setLastLogin(new Date());
				UserService.updateUser(loggedUser);
					
				if(!loggedUser.getAccountStatus().equals("active")) {
					response.put("type","fail");
					response.put("message","Account "+loggedUser.getAccountStatus());
					return response.toString();
				}
					
				session = request.getSession();
				session.setMaxInactiveInterval(60*15);
				session.setAttribute("loggedUser", loggedUser);
				
				response.put("type","success");
				response.put("message","logged in");
			
			}
			else{
				response.put("type","fail");
				response.put("message","Invalid Password");
			}
		}
		else
			response.put("message","Username doesnot exist");

		return response.toString();
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/register", produces = "application/json")
	public String addUser(@RequestBody User user) throws JSONException {
		
		JSONObject response = new JSONObject();
		
		if(user==null)
		{
			response.put("type","fail");
			response.put("message","Null user object");	
			return response.toString();
			
		}
		
		System.out.println(user.toString());
		
		String validationMessage = UserService.validateFields(user);
			
		user.setAccountStatus("active");
		user.setLastLogin(new Date());
		user.setUserType("customer");
			
		if(validationMessage.equals("success")) {
			
			User createdUser = UserService.addUser(user);	
			if(createdUser == null)
				response.put("message", "Unable to create account");
			else {
				

				Customer customer = new Customer();
				customer.setUserId(createdUser);
				customer = CustomerService.addCustomer(customer);
				createdUser.setCustomer(customer);
				UserService.updateUser(createdUser);
				
				response.put("type","success");
				response.put("message","Account created");	
				return response.toString();
			}	
			
		}
		else {
			response.put("message",validationMessage);	
			return response.toString();
		}		
		
		return response.toString();	
	}
		

	@RequestMapping(method=RequestMethod.POST,value="/logout", produces = "application/json")
	public String logout(HttpSession session) throws JSONException {
			
		JSONObject response = new JSONObject();
		
		if (session.getAttribute("loggedUser")==null)  {
			response.put("type","fail");
			response.put("message","Not Logged In");
		}
		else {
			session.invalidate();
			response.put("type","success");
			response.put("message","Logged out");
		}

		response.put("redirect","login");			
		return response.toString();		
	}


	@RequestMapping(method=RequestMethod.GET,value="/getUserDetails", produces = "application/json")
	public String userDetails(HttpSession session) throws JSONException {
		JSONObject response = new JSONObject();
		
		if(session.getAttribute("loggedUser")==null) {
			response.put("type","fail");
			response.put("message","Login needed");
		}
		else {
			response.put("type","success");
			response.put("user",(User) session.getAttribute("loggedUser"));
		}				
		
		return response.toString();
	}
	
}
