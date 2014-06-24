package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCTID")
	private int productId;
	
	@Column(name="PRODUCTNAME", unique=true, nullable= false)
	private String productName;
	
	@Column(name="PRODUCTPRICE", nullable= false)
	private double productPrice;
	
	@Column(name="PRODUCTDESC")
	private String productDesc;
	
	/*@Lob
	@Column(name="PRODUCT_IMAGE", nullable=false, columnDefinition="mediumblob")
	private byte[] productImage;*/

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CATGID")
	private Category category;

	public Product() {	}
	
	/*public Product(int productId, String productName, double productPrice,
			String productDesc, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.category = category;
	}*/

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	/*public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}*/
}
