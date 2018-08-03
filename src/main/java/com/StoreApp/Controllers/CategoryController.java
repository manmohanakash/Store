package com.StoreApp.Controllers;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StoreApp.Models.Category;
import com.StoreApp.Models.User;
import com.StoreApp.Services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService CategoryService;
	
	@RequestMapping(method=RequestMethod.POST,value="/createCategory", produces = "application/json")
	public String createCategory(HttpSession session,@RequestBody Category category) throws JSONException {
		
		JSONObject response = new JSONObject();
		
		if (session.getAttribute("loggedUser")==null)  {
			response.put("type","fail");
			response.put("message","Not Logged In");
		}
		else if(!((User)session.getAttribute("loggedUser")).getUserType().equals("customer")) {
			
			Category newCategory = CategoryService.addCategory(category);
			if(newCategory!=null) {
			response.put("type","success");
			response.put("message","Category added");
			}
			else {
				response.put("type","fail");
				response.put("message","Something went wrong");	
			}
		}
		else {
			response.put("type","fail");
			response.put("message","Customer access restricted");	
		}
		return response.toString();		
	}
}
