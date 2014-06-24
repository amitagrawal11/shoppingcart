package DAOLayer;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Model.Admin;
import Model.User;

public class AdminDbDAO {
	public  static boolean status ;
	private static SessionFactory factory = null;
	private static Session dbSession = null;
	private static Transaction getTransaction = null;

	public static boolean getUserAuthenticate(String formUsername, String formPassword){
		status = false;

		try {
			factory = HibernateUtil.getSessionFactory();

			dbSession = factory.openSession();

			Query getVerifyData = dbSession.createQuery("from User where username like '"+ formUsername+"' and password like '"+formPassword+"'");
		
			User userData =  (User) getVerifyData.uniqueResult();
			
			if(userData != null){
				
				if(userData.getUsername().equals(formUsername) && userData.getPassword().equals(formPassword)){
					System.out.println("true ....");   // debugging statement 
					status = true;
				}	
			}else{
				return status=false;
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		}finally{
			try {
				dbSession.close();
				factory.close();
			} catch (HibernateException he) {
				he.printStackTrace();
			}
		}
		return status;
	}

	public static boolean getAdminAuthenticate(String adminUsername,
			String adminPassword) {
		if((adminUsername.equals("amit")||adminUsername.equals("atul")) && adminPassword.equals("admin")){
			status = true;
		}
		return status;
	}

	public static boolean addNewUser(User newUser){
		try {
			status =false;
			factory = HibernateUtil.getSessionFactory();
			dbSession = factory.openSession();
			getTransaction = dbSession.beginTransaction();
			dbSession.save(newUser);
			getTransaction.commit();
			status = true;
		} catch (HibernateException he) {
			he.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbSession.close();
			factory.close();
		}
		return status;
	}

	public static boolean addNewAdmin(Admin newAdmin){
		try {
			status =false;
			factory = HibernateUtil.getSessionFactory();
			dbSession = factory.openSession();
			getTransaction = dbSession.beginTransaction();
			dbSession.save(newAdmin);
			getTransaction.commit();
			status = true;
		} catch (HibernateException he) {
			he.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbSession.close();
			factory.close();
		}
		return status;
	}

	
}
