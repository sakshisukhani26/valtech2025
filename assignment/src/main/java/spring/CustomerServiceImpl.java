package spring;

import hibernate.Customer;
import hibernate.Customer.CustomerStatus;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO c = new CustomerDAOImpl();
	
	@Override
	public void addCustomer(Customer customer) {
		c.save(customer);
	}
	
	@Override
	public void deleteCustomer(int id) {
		c.delete(id);
	}
	
	@Override
	public void enableCustomer(Customer cust) {
		cust.setCustStatus(CustomerStatus.ENABLED);
		c.update(cust);
	}
	
	@Override
	public void disableCustomer(Customer cust) {
		cust.setCustStatus(CustomerStatus.DISABLED);
		c.update(cust);
	}
	
	public void setC(CustomerDAO c) {
		this.c = c;
	}
}
