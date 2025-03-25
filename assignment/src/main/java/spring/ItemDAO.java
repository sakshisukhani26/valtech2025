package spring;

import java.util.List;

import org.hibernate.cache.ReadWriteCache.Item;

import hibernate.Items;



public interface ItemDAO {

	void save(Items i);
	void update(Items i);
	void delete(int id);
	Items get(long id);
	List<Items> getAll();
}
