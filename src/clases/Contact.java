package clases;

import java.time.LocalDate;
import java.time.Period;

public class Contact {
	
	private  String name;
	private String city;
	private String phoneNumber;
	private LocalDate birth;
	
	public Contact(String name, String city, String phoneNumber, LocalDate birth) {
		super();
		this.name = name;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}


	public int getAge(){
		return Period.between(birth, LocalDate.now()).getYears();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public LocalDate getBirth() {
		return birth;
	}


	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
	
	

}
