package com.luv2code.hibernate;

import com.luv2code.demo.entity.Student;
import org.hibernate.Session;

public class PrimaryKeyDemo {
    public  static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Student student1 = new Student("Toy","Jacob","toyjacob@gmail.com");
            Student student2 = new Student("Laina","Toy","lainatoy@gmail.com");
            Student student3 = new Student("Beena","Toy","beenatoy@gmail.com");
            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
            session.close();
        }
        finally {
            session.close();
        }
    }
}
