package com.dxc.mavenhibernet;


import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student std=new Student();
        std.setName("john");
        std.setRollno("cs2");
        std.setMarks(98.3f);
        
        Configuration cfg =new Configuration().configure().addAnnotatedClass(Student.class);
       SessionFactory sfactory=cfg.buildSessionFactory();
       Session session =sfactory.openSession();
       Transaction tx=session.beginTransaction();
       session.save(std);
       tx.commit();
    }
}
