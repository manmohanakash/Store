package com.StoreApp.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


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
    
    @Max(100)
	private Integer discount=0;
    
    @Column(columnDefinition="TEXT")
    private String description;
    
    @Min(0)
    @Column(columnDefinition="INTEGER(10) UNSIGNED")
    private Integer count=0;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id",columnDefinition="INTEGER(10) UNSIGNED",foreignKey=@ForeignKey(name="Fk_product_categoryId"))
    private Category category;
    
    public Product() {}
    
	public Product(Integer productId, String name, String company, Integer price, Integer discount, String description, Integer count,
			Category category) {
		super();
		this.productId = productId;
		this.name = name;
		this.company = company;
		this.price = price;
		this.description = description;
		this.count = count;
		this.discount = discount;
		this.category = category;
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
    
	
    
}
