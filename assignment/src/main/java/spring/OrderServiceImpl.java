package spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import hibernate.Customer;
import hibernate.Items;
import hibernate.LineItem;
import hibernate.Orders;

public class OrderServiceImpl implements OrderService{
	OrderDAO orderdao = new OrderDAOImpl();
    CustomerDAO dao = new CustomerDAOImpl();
    
    InventoryService is;
   
    @Autowired
    private HibernateTemplate hibernateTemplate; 
    
	@Override
	public Orders createOrder(Long custId, List<LineItem> lineitem) {
		Customer customer = dao.get(custId);
		Orders order = new Orders();
		order.setCustomer(customer);
		order.setStatus("NEW");
		order.setLineItems(lineitem);
		orderdao.save(order);
		for(LineItem lineItem : lineitem) {
			boolean inventoryUpdated = is.updateInventory(lineItem.getId(),lineItem.getQty());
			if(inventoryUpdated) {
				lineItem.setOrder(order);
				hibernateTemplate.save(lineItem);
				 order.getLineItems().add(lineItem);
			}else {
                // Handle cases where stock is not enough, you can log or notify customer
                System.out.println("Not enough stock for Item ID: " + lineItem.getItem().getId());
            }
		}
		 order.setStatus("Confirmed");
	     orderdao.update(order);

	     return order;
	}
	
	
//	private List<Orders> orders = new ArrayList<>();
//    private List<Customer> customers = new ArrayList<>();
//    private List<Items> items = new ArrayList<>();
//    OrderDAO order = new OrderDAOImpl();
//    CustomerDAO dao = new CustomerDAOImpl();
//	@Override
//	public Orders createOrder(Long custId, List<LineItem> lineitem) {
//		Customer customer = dao.get(custId);
//        if (customer == null) {
//            throw new RuntimeException("Customer not found");
//        }
//
//		
//		Orders order = new  Orders();
//		order.setCustomer((Customer) customers);
//		order.setStatus("NEW");
//		 order.setLineItems(lineitem);
//
//	        // "Persist" the order to the in-memory list
//	        orders.add(order);
//
////	        for (LineItem lineItem : lineitem) {
////	            updateInventory(lineItem.getItem(), lineItem.getQty());
////	        }
//
//	        return order;
//	}
//	
////	public void updateInventory(Items item, int quantityOrdered) {
////        Items existingItem = findItemById(item.getId());
////        if (existingItem != null) {
////            existingItem.setQty(existingItem.getQty() - quantityOrdered);
////        }
////    }
//	

}
