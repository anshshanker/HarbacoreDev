package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name="hbc_user")
public class SpecimenDto {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sno")
    private int sno;
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "gstin")
    private String gstin;
    @Column(name = "password")
    private String password;


    public SpecimenDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gst) {
        this.gstin = gst;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Username: "+username+", Email id: "+email;
    }
}