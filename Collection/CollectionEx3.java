package com.mphasis.main;

import java.util.Stack;

public class CollectionEx3 {
    public static void main(String args[]) {
        // Create a collection.
        Stack<String> adq = new Stack<>();

        // Use the collection like a stack.
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.print("Popping the stack: ");

        while(adq.peek() != null)
            System.out.print(adq.pop() + " ");

        System.out.println();
    }
}
