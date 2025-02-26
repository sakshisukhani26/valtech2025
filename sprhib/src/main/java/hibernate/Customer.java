package hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name = "custseq",sequenceName = "cust_seq",allocationSize = 1)
	
	private long id;
	private String name;
	private int age;
	private boolean gender;
	
	//mapped by is the field on the child where join column definition is defined
	//in address there will be a field called customer where i will define join col
	@OneToOne(targetEntity = Address.class,mappedBy = "customer")
	private Address address;
	@ManyToMany(targetEntity = Account.class,fetch = FetchType.LAZY)
	@JoinTable(name = "customer_account"
		,joinColumns = @JoinColumn(name = "customer_id",referencedColumnName = "id")
		,inverseJoinColumns = @JoinColumn(name = "account_id",referencedColumnName = "id"))
	private Set<Account> accounts;
	
	public Customer() {}
	
	
	public Customer(String name, int age, boolean gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ "]";
	}


	public void addAccount(Account acc) {
		if(accounts==null) accounts = new HashSet<Account>();
		accounts.add(acc);
		if(acc.getCustomers()==null) acc.setCustomers(new HashSet<Customer>());
		acc.getCustomers().add(this);
	}

	public void removeAccount(Account acc) {
		accounts.remove(acc);
		acc.getCustomers().remove(null);
	}
	
	public Set<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
	
}
