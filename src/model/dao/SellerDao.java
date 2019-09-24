package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer Id);
	Seller findById(Integer Id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);

}
