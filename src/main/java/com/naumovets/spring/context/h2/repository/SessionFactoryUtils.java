package com.naumovets.spring.context.h2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtils {
    SessionFactory sessionFactory;

    public SessionFactoryUtils() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void shutdown() {
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

}
