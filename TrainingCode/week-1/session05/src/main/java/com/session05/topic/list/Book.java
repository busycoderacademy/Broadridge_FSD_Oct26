package com.session05.topic.list;

import java.util.Comparator;

//Now its time to see Comprator: used to define extra sort sequence

//Sort as per price if price is same sort as per author name

class BookComparatorAsPerPriceThenAsPerAutherName implements  Comparator<Book>{
	@Override
	public int compare(Book o1, Book o2) {
		int compare=Double.compare(o1.getPrice(), o2.getPrice());

		if(compare==0){
			String book1Author=o1.getAuthor();
			String book2Author=o2.getAuthor();
			compare= book1Author.compareTo(book2Author);
		}
		return compare;
	}
}
class BookComparatorAsPerAuthorName implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
		String book1Author=o1.getAuthor();
		String book2Author=o2.getAuthor();
		return book1Author.compareTo(book2Author);
	}
}
public class Book implements Comparable<Book> {
	private int id;
	private String title;
	private String author;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book(int id, String title, String author, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	public Book() {
	}

	@Override  //this   o : java called this method i just provide aka call back
	public int compareTo(Book o) {
		return Integer.compare(this.id, o.id);
	}
}
