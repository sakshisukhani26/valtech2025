package spring;

import hibernate.Customer;

public class CustomerService {

	CustomerDAO c = new CustomerDAOImpl();
	
	public void addCustomer(Customer customer) {
		c.save(customer);
	}
	
	public void deleteCustomer(int id) {
		c.delete(id);
	}
}
