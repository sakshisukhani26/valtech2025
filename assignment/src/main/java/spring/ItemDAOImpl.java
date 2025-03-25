package spring;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import hibernate.Items;



public class ItemDAOImpl implements ItemDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Items i) {
		new HibernateTemplate(sessionFactory).save(i);
	}

	@Override
	public void update(Items i) {
		new HibernateTemplate(sessionFactory).update(i);
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));		
	}

	@Override
	public Items get(long id) {
		return new HibernateTemplate(sessionFactory).load(Items.class, id);
	}
	
	@Override
	public List<Items> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Items i");
	}
	

}
