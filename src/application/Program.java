package application;

import java.time.LocalDate;
import java.time.Month;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {
		Department department = new Department(1, "Books");
		
		Seller seller = new Seller(
				21, "Bob", "bob@gmail.com",
				LocalDate.of(2000, Month.MARCH, 20), 
				3000.0, department);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(seller);
	}

}
