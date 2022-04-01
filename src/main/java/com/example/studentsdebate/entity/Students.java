package com.example.studentsdebate.entity;

import javax.persistence.*;

import lombok.Data;



@Entity
@Table(name="Students")
@Data
public class Students {
	
	
	
	
	public Students(String firstName, String lastName, String department, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.Department = department;
		this.Country = country;
	}

	public Students() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="department")
	private String Department;
	
	@Column(name="country")
	private String Country;
	
	
	
	public int getId() {
		return Id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "Students [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", Department="
				+ Department + ", Country=" + Country + "]";
	}

}
