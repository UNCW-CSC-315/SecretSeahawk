package edu.uncw.secretseahawk;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Person {

    @Id
    private long id;
    private String name;
    private int age;
    private String gift;
    private boolean done;

    public Person(long id, String name, int age, String gift, boolean done) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gift = gift;
        this.done = done;
    }

    public Person(String name, int age, String gift, boolean done) {
        this.name = name;
        this.age = age;
        this.gift = gift;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
