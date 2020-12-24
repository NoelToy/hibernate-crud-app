package com.luv2code.hibernate;

import com.luv2code.demo.entity.Student;
import org.hibernate.Session;

public class ReadStudentDemo {
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Student student = new Student("John","Doe","johndoe@gmail.com");
            session.beginTransaction();
            System.out.println(student);
            session.save(student);
            session.getTransaction().commit();

            session.beginTransaction();
            System.out.println("\nGetting Student With id: "+student.getId());

            Student getStudent = session.get(Student.class,student.getId());
            System.out.println("\nGet Complete: "+getStudent);
            session.getTransaction().commit();

            session.close();
        }
        finally {
            session.close();
        }

    }
}
