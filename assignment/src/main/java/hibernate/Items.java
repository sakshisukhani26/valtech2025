package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Items {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "itemseq")
	@SequenceGenerator(name = "itemseq",sequenceName = "item_seq",allocationSize = 1)
	private long id;
	private String name;
	private String description;
	private int qty;
	private int reorder_qty;
	private int max_qty;
	
	public Items() {}
	
	public Items(String name, String description, int qty, int reorder_qty, int max_qty) {
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.reorder_qty = reorder_qty;
		this.max_qty = max_qty;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", description=" + description + ", qty=" + qty + ", reorder_qty="
				+ reorder_qty + ", max_qty=" + max_qty + "]";
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getReorder_qty() {
		return reorder_qty;
	}
	public void setReorder_qty(int reorder_qty) {
		this.reorder_qty = reorder_qty;
	}
	public int getMax_qty() {
		return max_qty;
	}
	public void setMax_qty(int max_qty) {
		this.max_qty = max_qty;
	}
	
	
}
