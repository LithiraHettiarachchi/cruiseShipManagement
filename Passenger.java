package com.company;

public class Passenger {
    private String firstName;
    private String surname;
    private int expenses;

    public Passenger(String firstName, String surname, int expenses) {
        this.firstName = firstName;
        this.surname = surname;
        this.expenses = expenses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }
}
