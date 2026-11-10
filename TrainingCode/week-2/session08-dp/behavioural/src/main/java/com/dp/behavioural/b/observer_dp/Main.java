package com.dp.behavioural.b.observer_dp;

import java.util.Observer;

//Observable using  Built-in  Observable class
class NewsAgency {
	private String news;

	public void setNews(String news) {

	}
}

//Concrete Observers using Built-in Observer interface
class EmailSubscriber {

}

public class Main {

	public static void main(String[] args) {
//		NewsAgency agency = new NewsAgency();
//
//		Observer email = new EmailSubscriber();
//		Observer sms = new SMSSubscriber();
//		// Attach observers
//		agency.addObserver(email);
//		agency.addObserver(sms);
//
//		// Change news and notify all observers
//		agency.setNews("Java 21 Released!");
//		agency.setNews("Spring Boot 3.3 Update Announced!");
	}
}
