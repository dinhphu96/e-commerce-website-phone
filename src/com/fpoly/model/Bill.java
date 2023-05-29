package com.fpoly.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BILL database table.
 * 
 */
@Entity
@Table(name="BILL")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_Bill;

	@Column(name="Date")
	private Date  date = new Date();

	@Column(name="Status")
	private boolean status;

	@Column(name="Total")
	private int total;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Phone")
	private User user;

	//bi-directional many-to-one association to BillDetail
	@OneToMany(mappedBy="bill")
	private List<BillDetail> billDetails;

	public Bill() {
	}

	public int getID_Bill() {
		return this.ID_Bill;
	}

	public void setID_Bill(int ID_Bill) {
		this.ID_Bill = ID_Bill;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BillDetail> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public BillDetail addBillDetail(BillDetail billDetail) {
		getBillDetails().add(billDetail);
		billDetail.setBill(this);

		return billDetail;
	}

	public BillDetail removeBillDetail(BillDetail billDetail) {
		getBillDetails().remove(billDetail);
		billDetail.setBill(null);

		return billDetail;
	}

}