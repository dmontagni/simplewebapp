package it.webapp;

import org.hibernate.Session;

public class SingletonSession {
    private SingletonSession(){}

    public static Session getSession(){
        Session session = HibernateFactory.getFactoryMysql().openSession();
        return session;
    }
}
