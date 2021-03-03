package com.mphasis.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    int id;
    String name;
    int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class StreamColletor {
    public static void main(String[] args) {
        List<Person> people= createPerson();
        System.out.println( people.stream()
                .collect(Collectors.toMap(p ->p.getId(),p->p)));
        System.out.println( people.stream()
                .collect(Collectors.groupingBy(Person::getAge)));
        System.out.println( people.stream()
                .collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toList()))));


    }
    public  static List<Person> createPerson(){
        return Arrays.asList(
        new Person(1,"ram",20),
        new Person(2,"ravi",32),
        new Person(3,"seetha",40),
        new Person(4,"savi",32),
        new Person(5,"annie",40),
        new Person(6,"dysi",20)

        );
    }
}
