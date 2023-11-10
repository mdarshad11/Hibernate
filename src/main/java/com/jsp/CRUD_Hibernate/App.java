package com.jsp.CRUD_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();

		// ========================(Create Object)============================
		createObj(sf);
		// ========================(update Object)============================
		updateObj(sf, 101);
		// ========================(delete Object)============================
		deleteObj(sf, 101);
		// ========================(Read Object)============================
		readObj(sf, 101);

	}

	public static void createObj(SessionFactory sf) {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Student s1 = new Student(101, "Aj");
		Student s2 = new Student(102, "Bj");
		Student s3 = new Student(103, "Cj");

		session.save(s1);
		session.save(s2);
		session.save(s3);
		tran.commit();
		session.close();
	}

	public static void readObj(SessionFactory sf, int studentId) {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Student sObj = session.get(Student.class, studentId);
		System.out.println(sObj);

		tran.commit();
		session.close();
	}

	public static void updateObj(SessionFactory sf, int studentId) {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Student s = session.get(Student.class, studentId);
		s.setsName("Kaif");
		session.update(s);
		System.out.println(s);
		tran.commit();
		session.close();
	}

	public static void deleteObj(SessionFactory sf, int studentId) {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Student s = session.get(Student.class, studentId);
		session.delete(s);
		tran.commit();
		session.close();
	}

}
