package applicantion;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: Seller findById ===\n");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== Test 2: Seller findByDepartment ===\n");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.finByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== Test 3: Seller findByAll ===\n");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== Test 4: Seller insert ===\n");
		Seller newseller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newseller);
		System.out.println("Inserted! new Id " + newseller.getId());

		System.out.println("\n=== Test 5: Seller update ===\n");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update complete");
	}

}
