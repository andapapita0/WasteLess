package dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import persistent.FoodItem;;
 
public class FoodItemDao {
 
    public void addFoodItem(FoodItem foodItem) {
        try {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(foodItem);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
    }
    
    public void deleteFoodItem(FoodItem foodItem) {
        try {
        	Configuration configuration = new Configuration().configure();
        	SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	Transaction transaction = session.beginTransaction();
            session.delete(foodItem);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
    }
    
    public void updateFoodItem(FoodItem foodItem) {
        try {
        	Configuration configuration = new Configuration().configure();
        	SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	Transaction transaction = session.beginTransaction();
            session.update(foodItem);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
    }
    
    @SuppressWarnings("unchecked")
	public List<FoodItem> getAlldata(){    
    	List<FoodItem> contacts = new ArrayList<FoodItem>();
        try {
        	Configuration configuration = new Configuration().configure();
        	SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	Transaction transaction = session.beginTransaction();
            Query q = session.createQuery("from FoodItem ");
            contacts = (List<FoodItem>) q.list();
            transaction.commit();
            
           return contacts;  
        } catch (Exception e) {
        	System.out.println("error");
        	e.printStackTrace();
            return new ArrayList<>(); 
        }
    }
    
    public static void main(String[] args) throws ParseException {
    	
    	
    	FoodItemDao dao = new FoodItemDao();
		List<FoodItem> groceries = dao.getAlldata();
		String all = "";
		for(FoodItem grocery: groceries) {
			System.out.println(grocery.getName());
		}
		System.out.println(all);
    }
    
 
}