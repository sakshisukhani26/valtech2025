package spring;

import hibernate.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);

	void deleteCustomer(int id);

	void enableCustomer(Customer cust);

	void disableCustomer(Customer cust);

}