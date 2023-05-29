package com.fpoly.model;

public class Cart {

	private String ten;
	private int gia;
	private int soLuong;
	private int tongTien;

	public Cart() {
	}

	public Cart(String ten, int gia, int soLuong, int tongTien) {
		this.ten = ten;
		this.gia = gia;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

}
