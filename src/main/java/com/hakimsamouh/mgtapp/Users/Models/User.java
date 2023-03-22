package com.hakimsamouh.mgtapp.Users.Models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
<<<<<<< HEAD


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
=======
import org.springframework.lang.Nullable;
>>>>>>> fdf1b9e51eca66b42abe6fdfbac2f61780915ddc
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
   
    public String getAddess() {
        return addess;
    }
    public void setAddess(String addess) {
        this.addess = addess;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getNacion() {
        return nacion;
    }
    public void setNacion(String nacion) {
        this.nacion = nacion;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFormacion() {
        return formacion;
    }
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }
    public String getLenguage() {
        return lenguage;
    }
    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }
    public String getRedes() {
        return redes;
    }
    public void setRedes(String redes) {
        this.redes = redes;
    }

 
    private String email;
    String firstname;
    String lastname;
     String avatar;
    String addess;
    int age;
    String description;
    String nacion;
    String role;
    String telefon;
    String token;
    String password;
    String formacion;
    String lenguage;

<<<<<<< HEAD
    List<String> favoritPrograming= new ArrayList<String>();
     String redes;
    
=======
>>>>>>> fdf1b9e51eca66b42abe6fdfbac2f61780915ddc
     

    public User(long id, String email, String firstname, String lastname, String avatar, String addess,
            int age, String description, String nacion, String role, String telefon, String token, String password,
            String formacion, String lenguage, List<String> favoritPrograming, String redes) {
        this.id = id;
     
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.avatar = avatar;
        this.addess = addess;
        this.age = age;
        this.description = description;
        this.nacion = nacion;
        this.role = role;
        this.telefon = telefon;
        this.token = token;
        this.password = password;
        this.formacion = formacion;
        this.lenguage = lenguage;
        this.favoritPrograming = favoritPrograming;
        this.redes = redes;
    }
    public long getId() {
        return id;
    }
<<<<<<< HEAD
   
=======

>>>>>>> fdf1b9e51eca66b42abe6fdfbac2f61780915ddc
    public void setId(long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Nullable
    private ArrayList<String> favoritPrograming=new ArrayList<String>();

    public User(long id,String name, String email,String avatar) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.avatar=avatar;
    }

    public User() {
    }

<<<<<<< HEAD
 
=======
    public User(long id, String name, String email, ArrayList<String> favoritPrograming) {
        this.id = id;
        this.name = name;

        this.favoritPrograming = favoritPrograming;
    }

>>>>>>> fdf1b9e51eca66b42abe6fdfbac2f61780915ddc
   



    public String getEmail() {
        return email;
    }

   

    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public void setFavoritPrograming( List<String> favoritPrograming) {
=======


    public void setFavoritPrograming( ArrayList<String> favoritPrograming) {
>>>>>>> fdf1b9e51eca66b42abe6fdfbac2f61780915ddc
        
       
        if ((this.favoritPrograming.isEmpty()) || (this.favoritPrograming == null)) {
            String message = "There is no favorite programming language for " + getFirstname();
            this.favoritPrograming.add(message);
            this.favoritPrograming=favoritPrograming;
            } else {
            this.favoritPrograming=favoritPrograming;
        }

        
    }

    public List<String> getFavoritPrograming() {

        if ((this.favoritPrograming.isEmpty()) || (this.favoritPrograming == null)) {
<<<<<<< HEAD
            String message = "There is no favorite programming language for " + getFirstname();
=======
            String message = "No hay lenguaje de programación favorito para  " + getName();

>>>>>>> fdf1b9e51eca66b42abe6fdfbac2f61780915ddc
            this.favoritPrograming.add(message);
            return this.favoritPrograming;
         } else {

            return this.favoritPrograming;
        }

    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "User [id=" + id +  ", email=" + email + ", firstname=" + firstname + ", lastname="
=======

    
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", firstname=" + firstname + ", lastname="
>>>>>>> fdf1b9e51eca66b42abe6fdfbac2f61780915ddc
                + lastname + ", avatar=" + avatar + ", addess=" + addess + ", age=" + age + ", description="
                + description + ", nacion=" + nacion + ", role=" + role + ", telefon=" + telefon + ", token=" + token
                + ", password=" + password + ", formacion=" + formacion + ", lenguage=" + lenguage + ", redes=" + redes
                + ", favoritPrograming=" + favoritPrograming + "]";

    }

   

}
