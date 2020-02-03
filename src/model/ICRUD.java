package model;

import java.sql.SQLException;
import java.util.List;

public interface ICRUD<T> {

	T create(T entity) throws SQLException;
	T update(T entity) throws SQLException;
	void delete(int idEntity) throws SQLException;
	T findById(int idEntity) throws SQLException;
	List<T> findAll() throws SQLException;
	
}
