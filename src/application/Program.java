package application;

import java.util.Iterator;
import java.util.List;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("\n--- TEST 1: Seller findById ---\n");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);
		
		System.out.println("\n--- TEST 2: Seller findByDepartment ---\n");
		Department department = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);

		for (Seller itemSeller : listSeller) {
			System.out.println(itemSeller + "\n");
		}
	}

}
