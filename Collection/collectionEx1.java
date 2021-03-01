package com.mphasis.main;

import java.awt.*;
import java.util.*;

class Point<T>{
    private T x,y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point<?> point = (Point<?>) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
class Task{
    public LinkedHashSet<Point> getElement(){
        LinkedHashSet<Point> result=new LinkedHashSet<>();
        result.add(new Point(1,2));
        result.add(new Point(3,5));
        result.add(new Point(9,3));

        return  result;

    }

}

public class collectionEx1 {

    public static void main(String[] args) {
        Task task=new Task();
        Collection<Point> result=task.getElement();
        Iterator<Point> iterator= result.iterator();

        while(iterator.hasNext()){
            Point point=iterator.next();
            System.out.println(point);
        }
    }



}
