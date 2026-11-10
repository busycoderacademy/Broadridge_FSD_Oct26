package com.demo;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    @Tag("test")
    void helloTest() {
        System.out.println("TEST environment executed");
        assertEquals("HELLO", "hello".toUpperCase());
    }

    @Test
    @Tag("prod")
    void helloProd() {
        System.out.println("PROD environment executed");
        assertEquals(10, 5 + 5);
    }

    @Test
    @Tag("test")
    void welcomeTest() {
        System.out.println("Welcome TEST");
        assertTrue(true);
    }
}
