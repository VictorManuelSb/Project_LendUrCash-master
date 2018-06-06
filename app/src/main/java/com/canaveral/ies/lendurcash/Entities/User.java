package com.canaveral.ies.lendurcash.Entities;


import java.util.ArrayList;

public class User {
    private String user, mail, pass;
    private ArrayList<User> amigos;
    private ArrayList <Deuda> deudas;

    public User() {
    }

    public User(String user, String mail, String pass, ArrayList<User> amigos, ArrayList<Deuda> deudas) {
        this.user = user;
        this.mail = mail;
        this.pass = pass;
        this.amigos = amigos;
        this.deudas = deudas;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<User> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<User> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Deuda> getDeudas() {
        return deudas;
    }

    public void setDeudas(ArrayList<Deuda> deudas) {
        this.deudas = deudas;
    }
}
