package com.jsp.CRUD_Hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class CRUD_Using_NativeQ {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();

		// ========================(Create Object)============================
		createObj(sf);
		// ========================(update Object)============================
		updateObj(sf, 101,"PassNameHere");
		// ========================(delete Object)============================
		deleteObj(sf, 101);
		// ========================(Read Object)============================
		readObj(sf);

	}

	public static void createObj(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String createQuery = "INSERT INTO Employee (eId, eName) VALUES (:eId, :name)";
		Query query = session.createNativeQuery(createQuery);
		query.setParameter("eId", 101);
		query.setParameter("name", "arshad");
		query.setParameter("eId", 102);
		query.setParameter("name", "Kaif");

		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);

		transaction.commit();
		session.close();
	}

	public static void readObj(SessionFactory sf) {
		Session session = sf.openSession();
		
		NativeQuery<Object[]> query = session.createNativeQuery("select * from Grocery");
		List<Object[]> list = query.list();
		for (Object[] g : list) {
			System.out.println(Arrays.deepToString(g));
		}
		session.close();
	}

	public static void updateObj(SessionFactory sf, int EmployeeId,String eName) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		String updateQuery = "UPDATE students SET email =  WHERE id = :id";
		Query query = session.createNativeQuery(updateQuery);

		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);

		transaction.commit();
		session.close();
	}

	public static void deleteObj(SessionFactory sf, int EmployeeId) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery query=session.createNativeQuery("delete from Employee where eId=EmployeeId ",Employee.class);
		int rows=query.executeUpdate();
		System.out.println(rows+" rows deleted");
		transaction.commit();
		session.close();
	}

}
