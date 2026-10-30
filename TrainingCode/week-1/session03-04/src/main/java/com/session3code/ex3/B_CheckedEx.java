package com.session3code.ex3;
//i want to read a file
import java.util.*;
import java.io.*;

public class B_CheckedEx {
	public static void main(String[] args){
		//Unique words from the file: dsa ? Set (dont allow duplicates)
		Set<String> set = new HashSet<>();
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("data.txt")))){
			String line=null;
			while((line=bufferedReader.readLine())!=null){
				String tokens[]=line.split(" ");
				for(String token:tokens) {
					set.add(token.toLowerCase());
				}
			}
		}catch (IOException e){
			System.out.println(e);
		}

		for(String s: set){
			System.out.println(s);
		}
    }
}
