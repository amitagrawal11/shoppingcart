package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
//@NamedQueries({@NamedQuery(name=Category.FIND_ALL_CATEGORY, query="select category from Category category")})
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//public static final String FIND_ALL_CATEGORY = "FIND_ALL_CATEGORY";
	
	@Id
    @GeneratedValue
    @Column(name="CATGID")
	private int catgId;
	
	@Column(name="CATGNAME", unique=true, nullable=false)
	private String catgName;

	public Category() {	}
	
	/*public Category(int catgId, String catgName, Set<Product> products) {
		super();
		this.catgId = catgId;
		this.catgName = catgName;
	}*/

	public int getCatgId() {
		return catgId;
	}

	public void setCatgId(int catgId) {
		this.catgId = catgId;
	}

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

}
