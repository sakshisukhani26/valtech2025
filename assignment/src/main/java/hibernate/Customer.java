package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_tbl")
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name = "custseq",sequenceName = "cust_seq",allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String address;
	private String per_address;
	
	public Customer() {}
	
	public Customer(String name, int age, String address, String per_address) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.per_address = per_address;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPer_address() {
		return per_address;
	}
	public void setPer_address(String per_address) {
		this.per_address = per_address;
	}
	
	
}
