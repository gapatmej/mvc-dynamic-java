package entities;

import java.sql.Date;

public class Client {
	
	private int idClient;
	private String name;
	private String lastName;
	private int age;
	private Date dateBirth;
	private String email;
	
	public Client() {
		
	}
	
	public Client(int idClient, String name, String lastName, int age, Date dateBirth, String email) {
		this.idClient = idClient;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.dateBirth = dateBirth;
		this.email = email;
	}

	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Date getDateBirth() {
		return dateBirth;
	}



	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	

}
