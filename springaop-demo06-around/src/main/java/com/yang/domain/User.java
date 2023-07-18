package com.yang.domain;

import java.io.Serializable;

/**
 * @author: CY.Ma
 * @date: 2023/7/5 21:41
 * @Description:
 * @doc:
 */
public class User implements Serializable {
    private static final long serialVersionUID = -433318868175802603L;

    private String name;

    private Integer age;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
