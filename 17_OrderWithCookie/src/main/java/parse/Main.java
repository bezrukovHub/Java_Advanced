package parse;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ua.com.library.dto.UserDTO;
import ua.com.library.entity.User;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		parse();


	}
	
	public static void parse() throws IOException{
		
		Document document =
				Jsoup.connect("http://www.shopbookshop.com/collections/books").get();


		for (Element element : document.select("span.grid-product__title")) {
			System.out.println(element.text());
		}

		System.out.println(document.select("span.grid-product__price")
				.text().replace("$ ", ""));
		
	}
	
	
}
