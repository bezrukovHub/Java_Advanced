package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String URL = "jdbc:mysql://localhost/logos";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	public static Connection conn;
	public static PreparedStatement ps;

	public static void main(String[] args) throws SQLException {

		// Створення з'єдднання з MySQL
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Перевірка конекту
		// if (conn != null) {
		// System.out.println("Connection successful!");
		// } else if (conn == null) {
		// System.out.println("Connection failed!");
		// System.exit(0);
		// }

		// Видалення таблиці, якщо вона вже існує
		String sql = "DROP TABLE IF EXISTS book";
		ps = conn.prepareStatement(sql);
		ps.execute();

		// Створення таблиці
		String sql2 = "CREATE TABLE IF NOT EXISTS book"
				+ " (`id` int not null auto_increment, `name` varchar(50),"
				+ " `pages` int, primary key(id))";
		ps = conn.prepareStatement(sql2);
		ps.execute();

		// Створення нового запису
		ps = conn
				.prepareStatement("INSERT INTO book (name, pages) VALUES (?, ?)");
		ps.setString(1, "LOTR");
		ps.setInt(2, 1500);
		ps.execute();

		ps.setString(1, "Fire and ice");
		ps.setInt(2, 500);
		ps.execute();

		// Оновлення запису
		ps = conn.prepareStatement("UPDATE book SET name = ? WHERE id = 1");
		ps.setString(1, "LOTRo");
		ps.execute();

		// Видалення запису
		// ps = conn.prepareStatement("DELETE FROM book WHERE pages > ?");
		// ps.setInt(1, 500);
		// ps.execute();

		// Зчитування інформації з БД
		List<Book> list = new ArrayList<Book>();

		// Дані отримуються лише в об'єкт типу ResultSet!
		ResultSet resSet = ps.executeQuery("SELECT * FROM book");

		// Далі з цього ResultSet можна передати інформацію в звичайний List
		while (resSet.next()) {
			list.add(new Book(resSet.getString(2), resSet.getInt(3)));
		}

		for (Book book : list) {
			System.out.println(book);
		}

		conn.close();
	}
}
