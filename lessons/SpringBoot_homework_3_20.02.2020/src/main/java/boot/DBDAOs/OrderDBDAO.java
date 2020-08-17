package boot.DBDAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.beans.Order;

public interface OrderDBDAO extends JpaRepository<Order, Integer>{

}
