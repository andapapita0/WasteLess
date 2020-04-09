package dao;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import persistent.User;

public class UserDao {
	
	public String authenticateUser(User user) {
		String username = user.getUsername(); //Keeping user entered values in temporary variables.
		String password = user.getPassword();
		String usernameDB = "";
		String passwordDB = "";
		try {
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from User ");
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) q.list();
			transaction.commit();
			for(User u:users) {
				usernameDB = u.getUsername();
				passwordDB = u.getPassword();
				if(username.equals(usernameDB) && password.equals(passwordDB)) {
					 return "success";
				}
			}
	         
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 return "invalid username or password!";
	}
	
	public static void main(String[] args) throws ParseException {
		User user = new User("andap", "aa");
		UserDao u = new UserDao();
		String s = u.authenticateUser(user);
		System.out.println(s);
	}

}
