package com.mphasis.com;

import java.awt.*;
import java.net.Inet4Address;

class Point<T>{
    private T x,y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Task1{
    public void test(Point<? extends Number> point){
        System.out.println(point);
    }
}
public class GenericsEx {
    public static void main(String[] args) {
        Point<Integer> point1=new Point<Integer>(2,4);
        Point<Float> point2=new Point<Float>(2.2f,4.5f);

        System.out.println(point1);
        System.out.println(point2);
        Task1 task=new Task1();
        task.test(new Point<Integer>(5,9));

    }
}
