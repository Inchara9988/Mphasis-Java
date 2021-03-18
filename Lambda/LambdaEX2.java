package com.mphasis.com;
interface Printer1 {
    public void print(String str,int number);
}


class Task{
     //perform method to print the values
    public void perform(Printer1 printer){
        printer.print("asasf",23);
    }
}

public class LambdaEX2 {
    public static void main(String[] args) {

        Task task=new Task();
              task.perform((text,number)-> System.out.println(text+number));
    }
}
