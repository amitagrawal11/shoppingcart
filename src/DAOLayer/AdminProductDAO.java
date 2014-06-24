package DAOLayer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Exceptions.MyException;
import Model.Category;
import Model.Product;

public class AdminProductDAO implements AdminInterfaceDAO{
	private boolean status = false;
	private Product newProduct= null;
	private Session session ;
	private Transaction getTransaction;
	
	@Override
	public boolean add(Object newObject) throws MyException {
		newProduct = new Product();
		status = false;
		System.out.println("adding the product .....into database");
		newProduct = (Product)newObject;
		try {
			status =false;
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			session.save(newProduct);
			getTransaction.commit();
			status = true;
		} catch (HibernateException he) {
			//System.out.println("testing...........products");
			he.printStackTrace();
			throw new MyException(he);
		}catch(final Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("return true from product addition in table");
		return status;
	}

	@Override
	public boolean remove(int id) throws MyException {
		try {
			status =false;
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			Query query = session.createQuery("delete from Product where productid="+id);
			int i = query.executeUpdate();
			getTransaction.commit();
			if(i>0){
				status = true;
			}
		} catch (HibernateException he) {
			throw new MyException(he);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return status;
	}

	@Override
	public boolean update(Object newObject) throws MyException {
		Product updateProduct = new Product();
		status = false;
		System.out.println("updating the product .....into database");
		updateProduct = (Product)newObject;
		try {
			status =false;
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			session.get(Product.class, updateProduct.getProductId());
			session.merge(updateProduct);
			getTransaction.commit();
			status = true;
		} catch (HibernateException he) {
			throw new MyException(he);
		}catch(final Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("return true from product addition in table updating....");
		return status;
	}

	@Override
	public List<?> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<?> getProductsByCatg(Category category) throws MyException {
		List<?> products = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			Query query = session.createQuery("FROM Product where catgid="+category.getCatgId());
			products = query.list();
		} catch (HibernateException he) {
			throw new MyException(he);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return products;
	}

	public Product getProductById(int productId) throws MyException {
		Product product = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			Query query = session.createQuery("FROM Product where productId="+productId);
			product = (Product)query.uniqueResult();
		} catch (HibernateException he) {
			throw new MyException(he);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return product;
	}

	public List<?> getProductsByCatg(int catgId) throws MyException {
		List<?> products = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			Query query = session.createQuery("FROM Product where catgid="+catgId);
			products = query.list();
		} catch (HibernateException he) {
			throw new MyException(he);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return products;
	}
}
