package com.hakimsamouh.mgtapp.Users.Models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="Users")
public class User  implements Serializable{
    @Id
    @SequenceGenerator(
        name = "users_seq",
        sequenceName = "users_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "users_seq"
        
    )
    private long id;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String name;
    private String email;
    private ArrayList<String> favoritPrograming;

    public User() {
    }

    public User(long id,String name, String email) {
        this.id=id;
        this.name = name;
        this.email = email;
    }

    public User(ArrayList<String> favoritPrograming) {
        this.favoritPrograming = favoritPrograming;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavoritPrograming(ArrayList<String> favoritPrograming) {
        this.favoritPrograming = favoritPrograming;
    }

    public List<String> getFavoritPrograming() {

        if ((favoritPrograming.isEmpty()) || (favoritPrograming == null)) {
            String message = "No hay lenguaje de programación favorito para  " + getName();

            favoritPrograming.add(message);
            return favoritPrograming;
        } else {
            return favoritPrograming;
        }

    }

    @Override
    public String toString() {
        return "EjemploController [name=" + name + ", email=" + email + "]";
    }

}
