package ua.com.library.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ua.com.library.entity.Book;

public class Main {
	public static void main(String[] args) {
 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		// доступ до транзакції та її відкриття
		session.beginTransaction();
		// збереження обєкту

		Book book = new Book();

		book.setName("LOTR");
		

//		session.save(book);
		// доступ до транзакції та її виконання
		session.getTransaction().commit();
		// закриття сесії
		session.close();
		sessionFactory.close();

	}
}
