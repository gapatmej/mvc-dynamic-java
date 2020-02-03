package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class EntityBase<T> {
	
	Connection connection;
	PreparedStatement preparedStatement;
	StringBuilder query ;
	T entity;
	List<T> listEntity;
	
	public EntityBase(Class<T> classEntity) {
		this.createConnection();
		try {
			this.entity = classEntity.newInstance();
		}catch (Exception e) {
			
		}
		this.listEntity = new ArrayList<>();
	}
	
	private void createConnection() {
		try {
			Class.forName("org.postgresql.Driver"); 
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crud_andresv1","postgres", "usrAdmin");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
