package it.webapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



import java.io.Serializable;
import java.util.List;

import static it.webapp.SingletonSession.getSession;

public class DeleteUserManager {
    /**
     * Questo metodo accetta un oggetto di tipo Customer in input e lo salva sul database
     * @param user il customer da salvare
     * @return boolean true se l'oggetto è stato salvato correttamente
     * */
    public boolean saveUser(User user){
        getSession().getTransaction().begin();
        Serializable obj = getSession().save(user);
        getSession().getTransaction().commit();
        if(obj != null){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Questo metodo ritorna una lista di oggetti Customer
     * @return List<Customer> lista di customer
     * */
    public List<User> getAllUsers(){
        List<User> users = getSession().createQuery("from User", User.class).getResultList();
        return users;
    }

    /**
     * Questo metodo ritorna un utente ricevendo uno username in input
     * @return User user
     * */
    public User getUser(String username){
        Query query = getSession().createQuery("FROM User u WHERE u.username=:username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    public Customer getUserInfo(Integer userId){
        Query query = getSession().createQuery("FROM Customer u WHERE u.iduser_x=:iduser");
        query.setParameter("iduser", userId);
        return (Customer) query.uniqueResult();
    }
    
    
    
    /*===========================================METODI MIRKO MARCO==============================*/
    
    
    
    
	public static Integer getUserId(String usrn){
		org.hibernate.Session session = HibernateFactory.getFactoryMysql().openSession();
	    Query query = session.createQuery("SELECT idUser FROM User u WHERE u.username=:usrn");
	    query.setParameter("usrn", usrn);
	    return (Integer) query.uniqueResult();
	}
    
    
    
    public static void deleteUser(int id) { 
		 //Create session factory object
		  SessionFactory sessionFactory = HibernateFactory.getFactoryMysql();
		  //getting session object from session factory
		  org.hibernate.Session session = sessionFactory.openSession();
		  //getting transaction object from session object
		  session.beginTransaction();
		  User user = (User)session.load(User.class, id);
		  session.delete(user);
		  System.out.println("Deleted Successfully");
		  session.getTransaction().commit();
		     sessionFactory.close();
   }
    
    public boolean validate(String username) {
    	
        Transaction transaction = null;
         User user = null;
         try (Session session = HibernateFactory.getFactoryMysql().openSession()) {
             // start a transaction
             transaction = session.beginTransaction();
             // get an user object
             user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                 .uniqueResult();

             if (user != null) {
    
                 return true;
             }
             // commit transaction
             transaction.commit();
         } catch (Exception e) {
             if (transaction != null) {
                 transaction.rollback();
             }
             e.printStackTrace();
         }
         return false;
     }

}