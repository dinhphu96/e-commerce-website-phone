package com.fpoly.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoanhThu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	Integer gourp; // Month(Date) of Bill
	Long total;

	public DoanhThu() {
		super();
	}

	public DoanhThu(Integer gourp, Long total) {
		super();
		this.gourp = gourp;
		this.total = total;
	}

	public Integer getGourp() {
		return gourp;
	}

	public void setGourp(Integer gourp) {
		this.gourp = gourp;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
}
