package com.jobportal;

import com.jobportal.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ThrowawayMain {
    public static void main(String[] args) {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        System.out.println("SessionFactory built successfully ");

        Session session  = sessionFactory.openSession();
        System.out.println("Session open? " + session.isOpen());

        session.close();
        System.out.println("Session closed successfully ");

    }
}
