package com.session3code.ex3;
//i want to read a file


import java.io.*;
import java.util.*;
public class B_CheckedEx {
	public static void main(String[] args){
		Set<String> set = new HashSet<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("data.txt")))) {
			String line=null;
			while((line = bufferedReader.readLine()) != null) {
				String tokens []=line.split(" ");
				for(String token:tokens) {
					set.add(token);
				}
			}
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }catch(IOException e){
			System.out.println("IO Exception");
		}

		for(String word: set){
			System.out.println(word);
		}
    }
}
