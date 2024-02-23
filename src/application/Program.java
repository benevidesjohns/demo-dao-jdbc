package application;

import java.time.LocalDate;
import java.time.Month;
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
		
		System.out.println("\n--- TEST 3: Seller findAll ---\n");
		List<Seller> listAllSeller = sellerDao.findAll();

		for (Seller itemSeller : listAllSeller) {
			System.out.println(itemSeller + "\n");
		}
		
		System.out.println("\n--- TEST 4: Seller insert ---\n");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.of(2000, Month.APRIL, 2), 3000.0, department);
		
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n--- TEST 5: Seller update ---\n");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		seller.setBaseSalary(4000.0);
		
		sellerDao.update(seller);
		System.out.println("Update completed!");
	}

}
