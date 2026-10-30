package com.session05.topic.list;

import java.util.*;

public class B_ArrayList {

	public static void main(String[] args) {
		//now i have list of user define data now how to print , sort etc
		//we need something called Comparable and comparator

		List<Book> books = new ArrayList<>();
		books.add(new Book(3, "Java: The Complete Reference", "Herbert Schildt", 55.00));
		books.add(new Book(4, "Head First Java", "Kathy Sierra", 42.75));
		books.add(new Book(5, "Spring in Action", "Craig Walls", 42.75));
		books.add(new Book(1, "Effective Java", "Joshua Bloch", 45.99));
		books.add(new Book(2, "Clean Code", "Robert C. Martin", 39.50));

//		books.stream().sorted(Comparator.comparing(Book::getAuthor)).forEach(System.out::println);



		System.out.println("------original list of the books------------------");
		printBookList(books);
		System.out.println("----------sort as per ID----------------");
		//defualt sort tech: natural sorting: comparable interface
		//extra sort sequence: comparator interface
		Collections.sort(books);//java dont know how to sort as per book....  comparable vs Comparator interface
		printBookList(books);
		//hey i want to sort as per author name
		System.out.println("-----sorted book as per author name-------");
		Collections.sort(books, new BookComparatorAsPerAuthorName());
		printBookList(books);

		System.out.println("sort as per price if price is same sort as per auther name");
		Collections.sort(books, new BookComparatorAsPerPriceThenAsPerAutherName());
		printBookList(books);

		//Lambda: "fucntional programming" lambda expression

	}

	private static void printBookList(List<Book> books) {
		for(Book book: books){
			System.out.println(book);
		}
	}


}



//		Iterator<Book> iterator = books.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}