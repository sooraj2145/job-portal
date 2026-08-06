package com.jobportal.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil(){}

    private static SessionFactory buildSessionFactory()  {

        try{

            Properties dbProps = new Properties();

            InputStream input = HibernateUtil.class.getClassLoader()
                    .getResourceAsStream("config.properties");

            if(input == null){
                throw new RuntimeException("config.properties file not found");
            }

            dbProps.load(input);
            input.close();

            Configuration configuration = new Configuration();

            configuration.configure("hibernate.cfg.xml");

            configuration.setProperty("hibernate.connection.driver_class", dbProps.getProperty("db.driver"));
            configuration.setProperty("hibernate.connection.url", dbProps.getProperty("db.url"));
            configuration.setProperty("hibernate.connection.username", dbProps.getProperty("db.username"));
            configuration.setProperty("hibernate.connection.password", dbProps.getProperty("db.password"));

           return configuration.buildSessionFactory();


        } catch (IOException e){
            throw new RuntimeException("Failed to load config.properties",e);
        }

    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }


}
