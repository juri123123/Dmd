package ddwu.spring.Dmd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity

@Table(name="product")
public class Product implements Serializable {
	
	@Id
	@SequenceGenerator(
			name = "prod_seq_generator",
			sequenceName = "prod_seq",
			initialValue = 1,
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "prod_seq_generator"
			)
	private int id;
	private int cateID;
	private int brandID;
	
	@Column(name="PRODNAME")
	private String name;
	
	private int price;
	private String content;
	private String prodIMGUrl;
	
	public Product(int id, int cateID, String name, int brandID, int price, String content,
 			String prodIMGUrl) {
 		super();
 		this.id = id;
 		this.cateID = cateID;
 		this.name = name;
 		this.brandID = brandID;
 		this.price = price;
 		this.content = content;
 		this.prodIMGUrl = prodIMGUrl;
 	}
	public Product(int id, int cateID, String name, int brandID, int price, String content) {
 		super();
 		this.id = id;
 		this.cateID = cateID;
 		this.name = name;
 		this.brandID = brandID;
 		this.price = price;
 		this.content = content;
 	}
	
	public Product(int id) {
		this.id = id;
	}
	
	public Product() {}
	
	
	
	/* JavaBeans Properties */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getProdIMGUrl() {
		return prodIMGUrl;
	}
	public void setProdIMGUrl(String prodIMGUrl) {
		this.prodIMGUrl = prodIMGUrl;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", cateID=" + cateID + ", name=" + name + ", brandID=" + brandID + ", price="
				+ price + ", content=" + content + ", prodIMGUrl=" + prodIMGUrl + "]";
	}
	
}
