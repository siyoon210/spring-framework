package me.siyoon.springbootlambdatest.dto;

public class UseRequest {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
