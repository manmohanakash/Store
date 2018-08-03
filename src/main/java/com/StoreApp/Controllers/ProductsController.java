package com.StoreApp.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StoreApp.Models.Product;
import com.StoreApp.Services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class ProductsController {

	
	@Autowired
	private ProductService ProductService;
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllProducts", produces = "application/json")
	public String getAllProducts(HttpSession session) throws JSONException, JsonProcessingException {
		
		JSONObject response = new JSONObject();
		JSONArray productsArray = new JSONArray();
		ObjectWriter write = new ObjectMapper().writer();

		ArrayList<Product> products = ProductService.getAllProducts();
		
		for(Product prod:products) {
			JSONObject json = new JSONObject(write.writeValueAsString(prod));
			productsArray.put(json);
		}
		response.put("type", "success");
		response.put("products", productsArray);
		return response.toString();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getProduct/{productId}", produces = "application/json")
	public String getAllProducts(@PathVariable Integer productId) throws JSONException, JsonProcessingException {
		
		JSONObject response = new JSONObject();	
		ObjectWriter write = new ObjectMapper().writer();
		
		Optional<Product> product = ProductService.getProductyById(productId);
		
		if(product.isPresent()) {
			response.put("type", "success");
			response.put("product", new JSONObject(write.writeValueAsString(product.get())));
		}
		else {
			response.put("type", "fail");
			response.put("message", "product with id doesnot exist");
		}
		
	
		return response.toString();
	}
	
	
	
	
}
