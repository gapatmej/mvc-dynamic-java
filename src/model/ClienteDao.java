package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entities.Client;

public class ClienteDao extends EntityBase<Client> implements ICRUD<Client> {

	public ClienteDao() {
		super(Client.class);
	}

	@Override
	public Client create(Client entity) throws SQLException {
		query = new StringBuilder(" insert into client (id_client, name, last_name, age, date_birth, email  ) ");
		query.append(" values (?,?,?,?,?,?)" );
		preparedStatement =  connection.prepareStatement(query.toString());
		preparedStatement.setInt(1, entity.getIdClient());
		preparedStatement.setString(2, entity.getName());
		preparedStatement.setString(3, entity.getLastName());
		preparedStatement.setInt(4, entity.getAge());
		preparedStatement.setDate(5, entity.getDateBirth());
		preparedStatement.setString(6, entity.getEmail());
		
		preparedStatement.executeUpdate();
		
		connection.close();
		
		return entity;
	}

	@Override
	public Client update(Client entity) throws SQLException {
		query = new StringBuilder(" update client ");
		query.append(" set name = ?, ");
		query.append(" last_name =?, ");
		query.append(" age = ?, ");
		query.append(" date_birth =?, ");
		query.append(" email =? ");
		query.append(" where id_client = ? ");
		 
		preparedStatement =  connection.prepareStatement(query.toString());
		preparedStatement.setString(1, entity.getName());
		preparedStatement.setString(2, entity.getLastName());
		preparedStatement.setInt(3, entity.getAge());
		preparedStatement.setDate(4, entity.getDateBirth());
		preparedStatement.setString(5, entity.getEmail());
		preparedStatement.setInt(6, entity.getIdClient());
		
		preparedStatement.executeUpdate();
		
		connection.close();
		return entity;
	}

	@Override
	public void delete(int idEntity) throws SQLException {
		query = new StringBuilder(" delete from client ");
		query.append(" where id_client = ? ");
		 
		preparedStatement =  connection.prepareStatement(query.toString());
		preparedStatement.setInt(1, idEntity);
		
		preparedStatement.execute();
		connection.close();
	}

	@Override
	public Client findById(int idEntity) throws SQLException {
		query = new StringBuilder(" select * from client ");
		query.append(" where id_client = ? ");
		 
		preparedStatement =  connection.prepareStatement(query.toString());
		preparedStatement.setInt(1, idEntity);
		
		ResultSet rs =  preparedStatement.executeQuery();
		
		while(rs.next()) {
			entity = rsToEntity(rs, entity);
		}
		connection.close();
		return entity;
	}

	@Override
	public List<Client> findAll() throws SQLException {
		query = new StringBuilder(" select * from client ");
		 
		preparedStatement =  connection.prepareStatement(query.toString());

		ResultSet rs =  preparedStatement.executeQuery();
		
		while(rs.next()) {
			listEntity.add(rsToEntity(rs, new Client()));
		}
		connection.close();
		return listEntity;
	}
	
	public List<Client> search(String word) throws SQLException {
		query = new StringBuilder(" select * from client where name like ? or last_name like ? ");
		 
		preparedStatement =  connection.prepareStatement(query.toString());
		preparedStatement.setString(1, "%"+ word + "%");
		preparedStatement.setString(2, "%"+ word + "%");
		
		ResultSet rs =  preparedStatement.executeQuery();
		
		while(rs.next()) {
			listEntity.add(rsToEntity(rs, new Client()));
		}
		connection.close();
		return listEntity;
	} 
	
	private Client rsToEntity(ResultSet rs, Client client) throws SQLException {
		client.setIdClient(rs.getInt("id_client"));
		client.setName(rs.getString("name"));
		client.setLastName(rs.getString("last_name"));
		client.setAge(rs.getInt("age"));
		client.setDateBirth(rs.getDate("date_birth"));
		client.setEmail(rs.getString("email"));
		return client;
	}

}
