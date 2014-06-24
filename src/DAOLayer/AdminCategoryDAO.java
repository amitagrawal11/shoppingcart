package DAOLayer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Exceptions.MyException;
import Model.Category;
public class AdminCategoryDAO implements AdminInterfaceDAO{
	private Category newCategory;
	private boolean status;
	private Session session ;
	private Transaction getTransaction;
	
	public boolean add(Object newObject) throws MyException {
		newCategory = (Category)newObject;
		try {
			status =false;
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			session.save(newCategory);
			getTransaction.commit();
			status = true;
		} catch (HibernateException he) {
			throw new MyException(he);			
		} catch(final Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return status;
	}

	public boolean remove(int id) throws MyException {
		try {
			status =false;
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			Query queryProd = session.createQuery("delete from Product where catgid="+id);
			int i = queryProd.executeUpdate();
			
			Query queryCatg = session.createQuery("delete from Category where catgid="+id);
			int i2 = queryCatg.executeUpdate();
			
			getTransaction.commit();
			if(i>0 || i2>0){
				status = true;
			}
		} catch (HibernateException he) {
			he.printStackTrace();	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return status;
	}

	public boolean update(Object newObject) throws MyException {
		Category updateCategory = new Category();
		updateCategory = (Category)newObject;
		try {
			status =false;
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			session.get(Category.class, updateCategory.getCatgId());
			session.merge(updateCategory);
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

	public List<?> readAll() throws MyException {
		List<?> categories = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			//Query query = session.getNamedQuery(Category.FIND_ALL_CATEGORY);
			Query query = session.createQuery("From Category");
			categories = query.list();
		} catch (HibernateException he) {
			throw new MyException(he);	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return categories;
	}
	
	public Category getCategoryByName(String categoryName) throws MyException{
		Category category =null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			Query query = session.createQuery("FROM Category where catgname like '"+categoryName +"'" );
			category = (Category) query.uniqueResult();
		} catch (HibernateException he) {
			throw new MyException(he);	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return category;
	}
	
	public Category getCategoryById(int catgId) throws MyException{
		Category category =null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			getTransaction = session.beginTransaction();
			Query query = session.createQuery("FROM Category where catgid ="+catgId );
			category = (Category) query.uniqueResult();
		} catch (HibernateException he) {
			throw new MyException(he);	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return category;
	}
}
