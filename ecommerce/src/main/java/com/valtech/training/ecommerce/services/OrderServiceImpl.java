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
import com.valtech.training.ecommerce.repos.OrderRepo;
import com.valtech.training.ecommerce.vos.OrderVO;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepo orderRepo;
	
    @Autowired
    InventoryService is;
   
//    @Autowired
//    private HibernateTemplate hibernateTemplate;
    
	@Override
	public boolean createOrder(OrderVO orderVO) {
		String message;
		Orders order = orderVO.to();
		if(order.getCustomer().getCustStatus()==CustomerStatus.DISABLED) {
			message = "User is disabled";
			return false;
		}
		List<LineItem> lt = order.getLineItems(); 
		System.out.println("lt------------------------"+lt);
		for(LineItem lineItem : lt) {
			Items it = lineItem.getItem();
			System.out.println("id : "+it.getId());
			System.out.println("----------------"+lineItem.getId());
			boolean inventoryUpdated = is.updateInventory(it.getId(), lineItem.getQty());
			if(!inventoryUpdated) {
				return false;
			}
			lineItem.setOrder(order);
//			ltdao.save(lineItem);
			is.setCurIfReq(lineItem.getItem().getId());
		}
		orderRepo.save(order);
		return true;
	} 

	@Override
	public List<Long> getListofLineItemsIds(List<LineItem> items){
		List<Long> ids = new ArrayList<Long>();
		for (LineItem i : items) {
			ids.add(i.getItem().getId());
		}
		return ids;
	}
	
	@Override
	public List<Integer> getListofLineItemsQty(List<LineItem> items){
		List<Integer> qty = new ArrayList<Integer>();
		for (LineItem i : items) {
			qty.add(i.getItem().getQty());
		}
		return qty;
	}
	
}
