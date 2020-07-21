package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SpecimenDto {



    private int sno;
    @Id
    private String email;
    private String username;
    private String gstin;
    private String password;



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