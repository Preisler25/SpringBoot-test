package com.example.demo.op;


import jakarta.persistence.*;

@Entity
@Table(name="operationshistory")
public class Operations{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int num1;
    private int num2;
    private String operator;

    public Operations(){

    }
    public Operations(long id, int num1, int num2, String operator) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public Operations(int num1, int num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operator='" + operator + '\'' +
                '}';
    }
}
