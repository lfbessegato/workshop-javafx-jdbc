package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	// Retorna um Seller
	public static SellerDao createSellerDao() {
		
		//Deixa protegido a implementação somente a instaciação
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
			return new DepartmentDaoJDBC(DB.getConnection());
	}
}
