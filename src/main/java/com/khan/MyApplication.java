package com.khan;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khan.entity.Address;
import com.khan.entity.Student;

public class MyApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.nextLine();

		System.out.println("Enter Mobile number");
		String phone = sc.nextLine();

		System.out.println("Enter State");
		String state = sc.nextLine();

		System.out.println("Enter City");
		String city = sc.nextLine();

		Address address = new Address();
		address.setCity(city);
		address.setState(state);
		Student student = new Student();
		student.setName(name);
		student.setMobileNo(phone);
		student.setAddress(address);

		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction txn = session.beginTransaction();
		session.save(student);
		session.save(address);
		txn.commit();
		session.close();
		factory.close();
		
		System.out.println("Data save successfully");

	}

}
