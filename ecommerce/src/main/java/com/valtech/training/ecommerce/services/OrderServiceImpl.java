package com.valtech.training.ecommerce.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer.CustomerStatus;
import com.valtech.training.ecommerce.entities.Items;
import com.valtech.training.ecommerce.entities.LineItem;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.entities.Orders.Status;
import com.valtech.training.ecommerce.repos.CustomerRepo;
import com.valtech.training.ecommerce.repos.OrderRepo;
import com.valtech.training.ecommerce.vos.OrderVO;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepo orderRepo;
	
    @Autowired
    InventoryService is;
    
    @Autowired
    ItemService itemService;
    
    @Autowired
    CustomerRepo customerRepo;
    
   
//    @Autowired
//    private HibernateTemplate hibernateTemplate;
    
	@Override
	public boolean createOrder(OrderVO orderVO) {
		System.out.println("++++++++++++++++++");
		long itemId = orderVO.itemId();
		int qty = orderVO.qty();
		long custId = orderVO.custId();
		LineItem lineItem = new LineItem();
		lineItem.setItem(itemService.getById(itemId).to());
		lineItem.setQty(qty);
		System.out.println("hello");
		String message;
		Orders order = new Orders();
//		if(order.getCustomer().getCustStatus()==CustomerStatus.DISABLED) {
//			message = "User is disabled";
//			return false;
//		}
		order.setStatus(Status.ORDERED);
//		order.addLineOrderItem(lineItem);
		order.setCustomer(customerRepo.getReferenceById(custId));
		order.setLineItems(List.of(lineItem));
		List<LineItem> lt = order.getLineItems(); 
		System.out.println("lt------------------------"+lt);
		for(LineItem lineItems : lt) {
			int quantities = lineItems.getQty();
			Items it = lineItems.getItem();
			System.out.println("id : "+it.getId());
			System.out.println("----------------"+lineItems.getId());
			boolean inventoryUpdated = is.updateInventory(it.getId(), lineItems.getQty());
			if(!inventoryUpdated) {
				return false;
			}
			lineItems.setOrder(order);
//			ltdao.save(lineItem);
			is.setCurIfReq(lineItems.getItem().getId());
		}
		
		orderRepo.save(order);
		return true;
	} 

//	public 
//	@Override
//	public List<Long> getListofLineItemsIds(List<LineItem> items){
//		List<Long> ids = new ArrayList<Long>();
//		for (LineItem i : items) {
//			ids.add(i.getItem().getId());
//		}
//		return ids;
//	}
//	
//	@Override
//	public List<Integer> getListofLineItemsQty(List<LineItem> items){
//		List<Integer> qty = new ArrayList<Integer>();
//		for (LineItem i : items) {
//			qty.add(i.getItem().getQty());
//		}
//		return qty;
//	}
	
}
