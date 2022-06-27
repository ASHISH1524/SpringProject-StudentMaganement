package com.SpringProject.API;

public class Student {

private int id=1;
private String name;
private Long mobileNumber;
private String location;
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
public Long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(Long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", location=" + location
			+ "]";
}

}
