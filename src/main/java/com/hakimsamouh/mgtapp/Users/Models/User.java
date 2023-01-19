package com.hakimsamouh.mgtapp.Users.Models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="Users")
@DynamicUpdate
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
     @Column
    private long id;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String name;
    private String email;
    private String avatar;
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Nullable
    private ArrayList<String> favoritPrograming=new ArrayList<String>();

    public User() {
    }

    public User(long id,String name, String email,String avatar) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.avatar=avatar;
    }

    public User(@Nullable ArrayList<String> favoritPrograming) {
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

    public void setFavoritPrograming(@Nullable ArrayList<String> favoritPrograming) {
        this.favoritPrograming = favoritPrograming;
    }

    public List<String> getFavoritPrograming() {

        if ((this.favoritPrograming.isEmpty()) || (this.favoritPrograming == null)) {
            String message = "No hay lenguaje de programación favorito para  " + getName();

            this.favoritPrograming.add(message);
            return this.favoritPrograming;
        } else {
            return this.favoritPrograming;
        }

    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", favoritPrograming=" + favoritPrograming
                + "]";
    }

   

}
