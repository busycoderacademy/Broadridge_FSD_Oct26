package com.session3code.ex4;

import java.io.*;

public class ByteStreams {
    public static void main(String[] args)throws IOException {
        //32 ms ===> 1 ms ==> 2ms
        //i am copying image file to the same location with diff name

        BufferedInputStream fis =new  BufferedInputStream(new FileInputStream("C:\\Users\\busyc\\OneDrive\\Desktop\\demo\\ali.jpg"));

        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\busyc\\OneDrive\\Desktop\\demo\\ali_copy.jpg"));

        long start = System.currentTimeMillis();



        //this is programmer managed buffer!
        int data=0;
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }
        fis.close();
        fos.close();

        long end = System.currentTimeMillis();
        System.out.println("time taken: " + (end - start) + " ms");





//        FileInputStream fis = new FileInputStream("C:\\Users\\busyc\\OneDrive\\Desktop\\demo\\ali.jpg");
//
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\busyc\\OneDrive\\Desktop\\demo\\ali_copy.jpg");
//
//        long start = System.currentTimeMillis();
//
//         byte[] byteBuffer=new byte[4*1024];
//
//         //this is programmer managed buffer!
//        int noOfByteReads=0;
//        while ((noOfByteReads = fis.read(byteBuffer)) != -1) {
//            fos.write(byteBuffer,0,noOfByteReads);
//        }
//        fis.close();
//        fos.close();
//
//        long end = System.currentTimeMillis();
//        System.out.println("time taken: " + (end - start) + " ms");
    }
}
