package com.fpoly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORY database table.
 * 
 */
@Entity
@Table(name="CATEGORY")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ID_Category;

	@Column(name="Ca_Name")
	private String ca_Name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category")
	private List<Product> products;

	public Category() {
	}

	public String getID_Category() {
		return this.ID_Category;
	}

	public void setID_Category(String ID_Category) {
		this.ID_Category = ID_Category;
	}

	public String getCa_Name() {
		return this.ca_Name;
	}

	public void setCa_Name(String ca_Name) {
		this.ca_Name = ca_Name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

}