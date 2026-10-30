package com.session05.topic.queue;

import java.util.PriorityQueue;

public class PriorityQue {

	public static void main(String[] args) {

		PriorityQueue<String> queue = new PriorityQueue<>();

		queue.add("Amit");
		queue.add("Vijay");
		queue.add("Karan");
		queue.add("Jai");
		queue.add("Rahul");
		
//		 Iterator<String> itr = queue.iterator();
//	      while (itr.hasNext()) {
//	            System.out.println(itr.next());
//	      }
//		
		while (!queue.isEmpty()) {
		    System.out.println(queue.poll());
		}

		
//		 Iterator<String> itr = queue.iterator();
//	      while (itr.hasNext()) {
//	            System.out.println(itr.next());
//	      }
		
//		 System.out.println("head: " + queue.element());
//		 System.out.println("head: " + queue.peek());
		 
	}

}
