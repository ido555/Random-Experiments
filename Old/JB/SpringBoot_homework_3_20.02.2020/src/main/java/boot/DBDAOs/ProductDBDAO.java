package boot.DBDAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.beans.Product;

public interface ProductDBDAO extends JpaRepository<Product, Integer> {

	Product findProductByName(String name);
	
}
