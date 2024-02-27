package application;

import java.util.List;
import java.util.Scanner;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;

public class Program2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n--- TESTE 1 - Department findById ---\n");
		Department department = departmentDao.findById(1);
		
		System.out.println(department);
		
		System.out.println("\n--- TEST 2: Department findAll ---\n");
		List<Department> listDepartment = departmentDao.findAll();
		
		for (Department dep: listDepartment) {
			System.out.println(dep + "\n");
		}

		System.out.println("\n--- TEST 3: Department insert ---\n");
		Department newDepartment = new Department(null, "DepTeste");
		
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n--- TEST 4: Seller update ---\n");
		
		department = departmentDao.findById(13);
		department.setName("DepTeste7");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n--- TEST 5: Department delete ---\n");
		System.out.println("\nEnter id for delete test: ");
		int id = scanner.nextInt();
		
		departmentDao.deleteById(id);
		
		System.out.println("\nDelete completed!");
		
		System.out.println("\n--- TEST 6: Department getSellers ---\n");
		System.out.println("\nEnter department id for get sellers");
		id = scanner.nextInt();
		
		List<Seller> listSeller = departmentDao.getSellers(id);
		
		for (Seller seller : listSeller) {
			System.out.println(seller + "\n");
		}
		
		scanner.close();
		
	}

}
