package spring;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import hibernate.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Customer c) {
		new HibernateTemplate(sessionFactory).save(c);
	}

	@Override
	public void update(Customer c) {
		new HibernateTemplate(sessionFactory).update(c);		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(id);		
	}

	@Override
	public Customer get(long id) {
		return new HibernateTemplate(sessionFactory).load(Customer.class, id);
	}

	@Override
	public List<Customer> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Customer c");
	}

}
