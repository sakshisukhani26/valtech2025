package spring;

import hibernate.Items;

public interface InventoryService {

	void createItem(Items i);

	// Update inventory quantity when an order is placed
	boolean updateInventory(Long itemID, int quantityOrdered);

	void setCurIfReq(long id);

	void setDao(ItemDAO dao);

}