package com.sergio.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sergio.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		// use the session object to save Java object
		try {
			
			// create 3 student objects;
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("John", "doe", "john@doe.com", null);
			Student tempStudent2 = new Student("Mary", "Public", "mary@public.com", null);
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@applebum.com", null);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
