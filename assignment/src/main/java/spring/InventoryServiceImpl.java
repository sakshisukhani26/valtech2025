package spring;

import org.springframework.beans.factory.annotation.Autowired;

import hibernate.Items;

public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	ItemDAO dao = new ItemDAOImpl();
	@Override
	public void createItem(Items i) {
		dao.save(i);
	}
	
	  // Update inventory quantity when an order is placed
    @Override
	public boolean updateInventory(Long itemID, int quantityOrdered) {
        Items existingItem = dao.get(itemID);
        if (existingItem != null && existingItem.getQty()>= quantityOrdered) {
            existingItem.setQty(existingItem.getQty() - quantityOrdered);
            dao.update(existingItem);
            return true;
        }
//        else {
//        	existingItem.setQty(existingItem.getQty() + (quantityOrdered - existingItem.getQty()));
//        	dao.update(existingItem);
        	return false;
//        }
    }
  
    @Override
	public void setCurIfReq(long id) {
    	
    	Items i = dao.get(id);
    	if(i.getQty()<i.getReorder_qty()) {
    		i.setQty(i.getMax_qty());
    	}
    }
    
    @Override
	public void setDao(ItemDAO dao) {
		this.dao = dao;
	}
}
