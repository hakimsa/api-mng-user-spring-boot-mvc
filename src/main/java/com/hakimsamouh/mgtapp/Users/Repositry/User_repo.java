package com.hakimsamouh.mgtapp.Users.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hakimsamouh.mgtapp.Users.Models.User;
@Repository
public interface  User_repo extends JpaRepository<User, Long>{

    //al method en jpa  en this interface
//@Query("SELECT e FROM User e WHERE s.email=?1")
Optional <User> findUserByEmail(String email);

}
