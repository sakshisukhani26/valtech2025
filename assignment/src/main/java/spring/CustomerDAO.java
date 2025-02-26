package spring;

import java.util.List;

import hibernate.Customer;


public interface CustomerDAO {

	void save(Customer c);
	void update(Customer c);
	void delete(int id);
	Customer get(long id);
	List<Customer> getAll();
	
}
