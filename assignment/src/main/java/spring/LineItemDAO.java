package spring;

import java.util.List;

import hibernate.LineItem;




public interface LineItemDAO {
	void save(LineItem i);
	void update(LineItem i);
	void delete(int id);
	LineItem get(long id);
	List<LineItem> getAll();
}
