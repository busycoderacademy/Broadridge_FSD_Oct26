package com.session3code.ex1;
import java.util.*;
interface Stack{
    void push(int data);
    int pop();
}
class StackArrayImpl implements  Stack {
    int[] arr = new int[5];
    int top = -1;
    // Push
   public void push(int data) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
    }
  public  int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
}
class StackLinkedListImpl implements   Stack {
    int[] arr = new int[5];
    int top = -1;
    // Push
   public void push(int data) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
    }
   public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
}
//by raj
public class G_WhyInterface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Rahul");
        list.add("Amit");
        list.add("John");
        list.add("Amit");

        Stack stack = new StackLinkedListImpl();
        stack.push(10);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
