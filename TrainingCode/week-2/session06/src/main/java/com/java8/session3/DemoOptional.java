package com.java8.session3;

import java.util.Optional;
import java.util.function.Supplier;

class CityNotFoundEx extends RuntimeException{}


public class DemoOptional {
	public static void main(String[] args) {
		Optional<String> optionalCity=getCityV1(443545);
//		String city=optionalCity.orElse("city not found");
//		System.out.println("city:"+city);
		String city=optionalCity.orElseThrow(CityNotFoundEx::new);
		System.out.println("city:"+city);
	}




//	//ravi
	public static Optional<String> getCityV1(int cordinate){

		//443545
		String c=null;
//		return  Optional.ofNullable(c);
		return Optional.ofNullable(c);
	}
}






