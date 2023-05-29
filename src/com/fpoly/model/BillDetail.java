package com.fpoly.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BILL_DETAIL database table.
 * 
 */
@Entity
@Table(name="BILL_DETAIL")
@NamedQuery(name="BillDetail.findAll", query="SELECT b FROM BillDetail b")
public class BillDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DETAIL")
	private int idDetail;

	@Column(name="Amount")
	private int amount;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="ID_Bill")
	private Bill bill;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ID_Product")
	private Product product;

	public BillDetail() {
	}

	public int getIdDetail() {
		return this.idDetail;
	}

	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}