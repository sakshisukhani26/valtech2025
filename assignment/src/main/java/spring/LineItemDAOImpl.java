package spring;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import hibernate.LineItem;



public class LineItemDAOImpl implements LineItemDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(LineItem i) {
		new HibernateTemplate(sessionFactory).save(i);
	}

	@Override
	public void update(LineItem i) {
		new HibernateTemplate(sessionFactory).update(i);		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));				
	}

	@Override
	public LineItem get(long id) {
		return new HibernateTemplate(sessionFactory).load(LineItem.class, id);
	}

	@Override
	public List<LineItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItem i");
	}

}
