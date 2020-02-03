package services;

import java.util.List;

import entities.Client;
import model.ClienteDao;

public class ServiceClient {

	ClienteDao clienteDao = new ClienteDao();
	
	public Client create(Client client) throws Exception{
		try {
			return clienteDao.create(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al crear el cliente");
		}
	}
	
	public Client update(Client client) throws Exception{
		try {
			return clienteDao.update(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al actualizar el cliente");
		}
	}
	
	public void delete(int idClient) throws Exception{
		try {
			clienteDao.delete(idClient);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al eliminar el cliente");
		}
	}
	
	public Client findById(int idClient) throws Exception{
		try {
			return clienteDao.findById(idClient);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al encontrar el cliente");
		}
	}
	
	public List<Client> findAll() throws Exception{
		try {
			return clienteDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al encontrar los clientes");
		}
	}
	
	public List<Client> search(String word) throws Exception{
		try {
			return clienteDao.search(word);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al encontrar los clientes");
		}
	}
}
