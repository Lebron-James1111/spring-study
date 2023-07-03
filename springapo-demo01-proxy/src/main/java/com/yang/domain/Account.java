package com.yang.domain;

import java.io.Serializable;

/**
 * 账户实体
 * @author: CY.Ma
 * @date: 2023/6/28 15:18
 * @description:
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 6985922097752980075L;

    private Long id ;

    private String name;

    private Double money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
