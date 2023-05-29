package com.fpoly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_Product;

	@Column(name="Image")
	private String image;

	@Column(name="Info")
	private String info;

	@Column(name="Pr_Name")
	private String pr_Name;

	@Column(name="Price")
	private int price;

	@Column(name="Quantity")
	private int quantity;

	//bi-directional many-to-one association to BillDetail
	@OneToMany(mappedBy="product")
	private List<BillDetail> billDetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="ID_Category")
	private Category category;

	public Product() {
	}

	public int getID_Product() {
		return this.ID_Product;
	}

	public void setID_Product(int ID_Product) {
		this.ID_Product = ID_Product;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPr_Name() {
		return this.pr_Name;
	}

	public void setPr_Name(String pr_Name) {
		this.pr_Name = pr_Name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<BillDetail> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public BillDetail addBillDetail(BillDetail billDetail) {
		getBillDetails().add(billDetail);
		billDetail.setProduct(this);

		return billDetail;
	}

	public BillDetail removeBillDetail(BillDetail billDetail) {
		getBillDetails().remove(billDetail);
		billDetail.setProduct(null);

		return billDetail;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}