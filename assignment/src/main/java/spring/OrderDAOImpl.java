package spring;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import hibernate.Customer;
import hibernate.Orders;

public class OrderDAOImpl implements OrderDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Orders o) {
			new HibernateTemplate(sessionFactory).save(o);
	}

	@Override
	public void update(Orders o) {
		new HibernateTemplate(sessionFactory).update(o);		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(id);	
	}

	@Override
	public Orders get(long id) {
		return new HibernateTemplate(sessionFactory).load(Orders.class, id);
		
	}

	@Override
	public List<Orders> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Orders o");
	}

}

