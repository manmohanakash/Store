package com.StoreApp.Models;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( columnDefinition="INTEGER(10) UNSIGNED")
    private Integer productId;
    
    @Column(length=50,nullable=false)
    private String name;
    
    @Column(length=50)
    private String company;
    
    @Column( columnDefinition="DECIMAL(10,2)")
    private Integer price;
    
	private Integer discount=0;
    
    @Column(columnDefinition="TEXT")
    private String description;
    
    @Column(columnDefinition="INTEGER(10) UNSIGNED")
    private Integer count;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id",columnDefinition="INTEGER(10) UNSIGNED",foreignKey=@ForeignKey(name="category_categoryid"))
    private Category category;
    
    
    @OneToMany(mappedBy="cartId.product",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonBackReference
    private Collection<Cart> cart;
   
	public Product() {}
    
	public Product(Integer productId, String name, String company, Integer price, Integer discount,
			String description, Integer count, Category category, Collection<Cart> cart) {
		super();
		this.productId = productId;
		this.name = name;
		this.company = company;
		this.price = price;
		this.discount = discount;
		this.description = description;
		this.count = count;
		this.category = category;
		this.cart = cart;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	
	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
	public Collection<Cart> getCart() {
		return cart;
	}

	public void setCart(Collection<Cart> cart) {
		this.cart = cart;
	}
	
    
}
