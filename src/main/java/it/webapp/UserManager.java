package it.webapp;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

import static it.webapp.SingletonSession.getSession;

public class UserManager {
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

}
