package spring;

import java.util.List;

import hibernate.Orders;


public interface OrderDAO {

	void save(Orders o);
	void update(Orders o);
	void delete(int id);
	Orders get(int id);
	List<Orders> getAll();
}
