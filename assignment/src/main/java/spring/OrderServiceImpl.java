package spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import hibernate.Customer;
import hibernate.Customer.CustomerStatus;
import hibernate.Items;
import hibernate.LineItem;
import hibernate.Orders;

public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDAO orderdao = new OrderDAOImpl();
	@Autowired
    CustomerDAO dao = new CustomerDAOImpl();
	@Autowired
	LineItemDAO ltdao = new LineItemDAOImpl();
    @Autowired
    InventoryService is;
   
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
	@Override
	public boolean createOrder(Orders order) {
		String message;
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
		orderdao.save(order);
		return true;
	} 
	
	public void setIs(InventoryService is) {
		this.is = is;
	}
	
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}
	public void setLtdao(LineItemDAO ltdao) {
		this.ltdao = ltdao;
	}
	public void setOrderdao(OrderDAO orderdao) {
		this.orderdao = orderdao;
	}
    

}
