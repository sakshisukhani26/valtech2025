package hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import hibernate.Customer;

@Entity
public class Orders {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq",sequenceName = "order_seq",allocationSize = 1)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private Customer customer;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<LineItem> lineItems;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status{
		ORDERED,PACKED,SHIPPED,DELIEVERD,CANCELLED
	}
	public Orders() {}

	public Orders(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customer=" + customer + ", lineItems=" + lineItems + ", status=" + status + "]";
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
