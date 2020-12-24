package com.luv2code.hibernate;

import com.luv2code.demo.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private  static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            try{
                //Setting properties
                Properties properties = new Properties();
                properties.put(Environment.URL,"jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                properties.put(Environment.USER, "hbstudent");
                properties.put(Environment.PASS, "hbstudent");
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.SHOW_SQL, true);
                properties.put(Environment.POOL_SIZE, 1);
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                Configuration configuration = new Configuration();
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Student.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
