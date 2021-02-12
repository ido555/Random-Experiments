package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Product;

@Component
public class ProductsDBDAO implements RowMapper<Product> {
	@Autowired // gotta call templet the same name as @Bean
	private JdbcTemplate getJdbcTemplate;

	public void addProduct(Product product) {
		getJdbcTemplate.update("INSERT INTO northwind.products(id, product_name, list_price, category) values(?,?,?,?)",
				product.getId(), product.getProductName(), product.getListPrice(), product.getCategory());
		// update - change the db = update, insert, delete
	}
	public void deleteProduct(int id) {
		getJdbcTemplate.update("DELETE FROM northwind.products WHERE id=?", id);
	}
	public List<Product> getAllProducts() {
		// this = ProductsDBDAO - mapRow?
		return getJdbcTemplate.query("SELECT * FROM northwind.products", this);
	}
	public Product getOneProduct(int id) {
		return getJdbcTemplate.queryForObject("SELECT * FROM northwind.products WHERE id =" + id, this);
	}
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4));
	}
}
