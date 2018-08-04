package com.StoreApp.Controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StoreApp.Models.Cart;
import com.StoreApp.Models.CartId;
import com.StoreApp.Models.Customer;
import com.StoreApp.Models.Product;
import com.StoreApp.Models.User;
import com.StoreApp.Services.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
public class CartController {
	
	@Autowired
	private CartService CartService;
	

	
	@RequestMapping(method=RequestMethod.GET,value="/getCart", produces = "application/json")
	public String getCart(HttpSession session) throws JSONException, JsonProcessingException {
		
		JSONObject response = new JSONObject();
		
		if (session.getAttribute("loggedUser")==null)  {
			response.put("type","fail");
			response.put("message","Not Logged In");
		}
		else {
			JSONArray itemsArray = new JSONArray();
			ObjectWriter write = new ObjectMapper().writer();
			User loggedUser = (User) session.getAttribute("loggedUser");
			ArrayList<Cart> items = CartService.getCartForCustomer(loggedUser.getCustomer().getCustomerId());
			
			for(Cart item:items) {
				JSONObject json = new JSONObject(write.writeValueAsString(item));
				itemsArray.put(json);
			}
			response.put("type", "success");
			response.put("products", itemsArray);
		}
			
		return response.toString();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/updateCartItem", produces = "application/json")
	public String addToCart(HttpSession session,@RequestBody String request) throws JSONException, JsonProcessingException {
		
		JSONObject response = new JSONObject();
		
		User loggedUser;
		
		if ((loggedUser = (User)session.getAttribute("loggedUser"))==null)  {
			response.put("type","fail");
			response.put("message","Not Logged In");
		}
		else {
			JSONObject obj = (JSONObject) new JSONTokener(request).nextValue();
			Integer quanity=Integer.parseInt(obj.get("quantity").toString());
			Integer productId= Integer.parseInt(obj.get("productId").toString());
			
			Customer currentCustomer = new Customer();
			currentCustomer.setCustomerId(loggedUser.getCustomer().getCustomerId());
			Product currentProduct = new Product();
			currentProduct.setProductId(productId);
			
			Cart cartItem = new Cart();
			cartItem.setQuantity(quanity);
			cartItem.setCartId(new CartId(currentProduct,currentCustomer));
			
			if(cartItem.getQuantity().equals(0)) {
				CartService.removeItemFromCart(cartItem);
				response.put("type", "success");
				response.put("message", "Item removed");
				return response.toString();				
			}					
			
			Cart addItem = CartService.addItemToCart(cartItem);
			if(addItem!=null) {
			response.put("type", "success");
			response.put("message", "Item added");
			}
			else {
				response.put("type", "fail");
				response.put("message", "Unable to added");
			}
		}
			
		return response.toString();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/clearCart", produces = "application/json")
	public String clearCart(HttpSession session) throws JSONException {
		
		JSONObject response = new JSONObject();
				
		if (session.getAttribute("loggedUser")==null)  {
			response.put("type","fail");
			response.put("message","Not Logged In");
		}
		else{
			Integer userId = ((User)session.getAttribute("loggedUser")).getCustomer().getCustomerId();
			CartService.clearCart(userId);
			response.put("type","success");
			response.put("message","Cart cleared");
		}
		return response.toString();
		
	}


}
