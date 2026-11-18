package com.model;

import java.util.ArrayList;
import java.util.List;
//BL should not in controller
public class BookAdviser {

	public static List<String> bookAdviser(String topic){
		List<String> list=new ArrayList<String>();
		
		if(topic.equalsIgnoreCase("Java")){
			list.add("head first");
			list.add("thinking in java");
		}else if(topic.equalsIgnoreCase("Servlet")){
			list.add("head first servlet jsp");
			list.add("core servlet.com");
		}else if(topic.equalsIgnoreCase("Spring")){
			list.add("Spring in action");
			list.add("black book");
		}else
			list.add("no book");
		
		return list;
	}
	}