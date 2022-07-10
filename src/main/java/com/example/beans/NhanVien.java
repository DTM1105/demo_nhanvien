package com.example.beans;

public class NhanVien {
    Integer id,age,salary,status;
    String name;

    public NhanVien() {
    }

    public NhanVien(String name,Integer age, Integer salary, Integer status) {
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.name = name;
    }

    public NhanVien(Integer id, String name, Integer age, Integer salary, Integer status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status=status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
