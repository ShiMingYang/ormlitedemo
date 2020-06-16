package com.sqw.ormdemosmy;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "persons")
public class Person {

     @DatabaseField(id = true)
     private String name;
     @DatabaseField
     private String password;
     @DatabaseField
     private String age;
     @DatabaseField
     private String sex;

    public Person() {

    }

    public Person(String name, String password, String age, String sex) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
