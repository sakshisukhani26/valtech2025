package spring;

import org.springframework.beans.factory.annotation.Autowired;

import hibernate.Orders;
import hibernate.Orders.Status;


public class OrderStatusService {
	

	@Autowired
	OrderDAO orderdao;
	
	
	public Status checkStatus(int orderId) {
		Orders o = orderdao.get(orderId);
		return o.getStatus();
	}
	
	public Status updateStatus(int orderId) {
		System.out.println("Order id " +orderId);
		Status status = orderdao.get(orderId).getStatus();
		
		Status[] statusstr = Status.values();
		
		int curInd = status.ordinal();
		int nextInd = curInd;
		
		if(curInd != statusstr.length-1) {
			nextInd++;
		}
		
		Orders o = orderdao.get(orderId);
		o.setStatus(statusstr[nextInd]);
		orderdao.update(o);
		return statusstr[nextInd];
	}
	
	public void setOrderdao(OrderDAO orderdao) {
		this.orderdao = orderdao;
	}
}
