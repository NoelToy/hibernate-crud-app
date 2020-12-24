package com.luv2code.hibernate;

import org.hibernate.Session;

public class HibernateDemoApp {

    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // Check database version
        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }
}
