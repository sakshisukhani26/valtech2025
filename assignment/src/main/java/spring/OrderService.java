package spring;

import java.util.List;

import hibernate.LineItem;
import hibernate.Orders;

public interface OrderService {

	public Orders createOrder(Long custId,List<LineItem> lineitem);
}
