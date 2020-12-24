package com.luv2code.hibernate;

import com.luv2code.demo.entity.Student;
import org.hibernate.Session;

public class CreateStudentDemo {

    public static void main(String[] args){
        Student student = new Student("Noel","Toy","noeltoy@gmail.com");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();
        }
        finally {
            session.close();
            HibernateUtil.shutdown();
        }

    }
}
