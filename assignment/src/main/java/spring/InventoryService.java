package spring;

import hibernate.Items;

public class InventoryService {
	
	Items item;
	ItemDAO dao = new ItemDAOImpl();
	public void createItem(Items i) {
		dao.save(i);
	}
	
	  // Update inventory quantity when an order is placed
    public boolean updateInventory(Long itemID, int quantityOrdered) {
        Items existingItem = dao.get(item.getId());
        if (existingItem != null && existingItem.getQty()>= quantityOrdered) {
            existingItem.setQty(existingItem.getQty() - quantityOrdered);
            dao.update(existingItem);
            return true;
        }else {
        	
        	existingItem.setQty(existingItem.getQty() + (quantityOrdered - existingItem.getQty()));
        	dao.update(existingItem);
        	return false;
        }
      
    }
    
    
}
