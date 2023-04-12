package com.digdes.school.models;

public class Values {

    private Integer id;
    private String lastName;

    private Integer age;
    private Integer cost;
    private Boolean active;




    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Values{" +
                "lastName='" + lastName + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", active=" + active +
                ", cost=" + cost +
                '}';
    }
}


