package com.spring.pojo;

public class Accout {
    private int id;
    private Long money;

    @Override
    public String toString() {
        return "Accout{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
