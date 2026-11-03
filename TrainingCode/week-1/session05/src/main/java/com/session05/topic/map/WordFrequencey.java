package com.session05.topic.map;
import java.awt.image.ImageProducer;
import java.io.*;
import java.util.*;
public class WordFrequencey {
    public static void main(String[] args) {
        /*
            1. Read the story.txt file
            2. Split the story into words
            3. Count the frequency of each word
            4. Print the word frequency1
         */
        //    Word -> Frequency
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("story.txt")));
            String line=null;
            while((line=bufferedReader.readLine())!=null){
               String[] words = line.split(" ");
               for(String word:words){
                   if(!wordFrequency.containsKey(word)){
                     wordFrequency.put(word,1);
                   }else{
                       int freq=wordFrequency.get(word);
                       wordFrequency.put(word,freq+1);
                   }
               }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        //finally i want to print the map
        Set<String> keys = wordFrequency.keySet();
        for(String key:keys){
            System.out.println(key+"->"+wordFrequency.get(key));
        }

    }
}
