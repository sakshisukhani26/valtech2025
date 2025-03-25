package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.LineItem;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.entities.Orders.Status;
import com.valtech.training.ecommerce.services.OrderService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public record OrderVO(long id,long custId,List<Long> itemIds ,List<Integer> qty,String status) {

	@Autowired
	static OrderService orderService;
	
	public static OrderVO from(Orders order) {
		long customerId = order.getCustomer().getId();
		List<Long> ids = orderService.getListofLineItemsIds(order.getLineItems());
		List<Integer> qty = orderService.getListofLineItemsQty(order.getLineItems());
		return new OrderVO(order.getId(),customerId,ids,qty,order.getStatus().name());
	}
	
	public Orders to() {
		Status stats = Status.valueOf(status);
		return new Orders(stats);
	}
}
