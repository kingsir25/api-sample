package com.example.demo.entity;

import java.util.List;

public class Person {

    private int id; //编号
    private String name; //姓名
    private String address_id; //地址邮编
    private List<String> addressList;//地址集合，存放地址


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public List<String> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address_id=" + address_id + ", addressList=" + addressList
				+ "]";
	}
}
