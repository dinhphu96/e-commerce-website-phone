package com.fpoly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Phone")
	private String phone;

	@Column(name="Adress")
	private String adress;

	@Column(name="Avartar")
	private String avartar;

	@Column(name="Email")
	private String email;

	@Column(name="FullName")
	private String fullName;

	@Column(name="Gender")
	private boolean gender;

	@Column(name="Password")
	private String password;

	@Column(name="Role")
	private boolean role;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="user")
	private List<Bill> bills;

	public User() {
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getAvartar() {
		return this.avartar;
	}

	public void setAvartar(String avartar) {
		this.avartar = avartar;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getRole() {
		return this.role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setUser(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setUser(null);

		return bill;
	}

}