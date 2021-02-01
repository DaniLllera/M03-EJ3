package com.company;

public class Datos {

 String username;
 int identifier;
 String firstname;
 String lastname;

    public Datos(String username, int identifier, String firstname, String lastname) {
        this.username = username;
        this.identifier = identifier;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "username='" + username + '\'' +
                ", identifier=" + identifier +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

