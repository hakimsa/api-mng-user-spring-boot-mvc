package com.hakimsamouh.mgtapp.Users.Services;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hakimsamouh.mgtapp.Users.Models.User;
import com.hakimsamouh.mgtapp.Users.Repositry.User_repo;


@Service
public class UserService {
    private final User_repo user_repo;

    @Autowired
    public UserService(User_repo user_repo) {
        this.user_repo = user_repo;
    }

    public List<User> getUsers() {
        return user_repo.findAll();
    }

    public Optional<User> getUser(Long idUser) {

        boolean isExist = user_repo.existsById(idUser);
        if (!isExist) {

            throw new IllegalStateException("User with this id  :" + idUser + " no exist");

        } else {
        }
        return user_repo.findById(idUser);
    }

    @Transactional
    public  String addNewUser(User user) {



        Optional<User> userEmail = user_repo.findUserByEmail(user.getEmail());
        if (userEmail.isPresent()) {
            throw new IllegalStateException("Email already exists, you could choose another one");
          
        }
        user_repo.save(user);
       return "ok";
    }

    public void deleteUser(Long idUser) {
        boolean isExist = user_repo.existsById(idUser);
        if (!isExist) {

            throw new IllegalStateException("User with this id  :" + idUser + " no exist");

        } else {
            user_repo.deleteById(idUser);
        }

    }

    @Transactional
    public void  updateUser(Long idUser, String firstname, String avatar,String email, String adress,int age,String formacion,String redes,String roles,String lenguage,String nacion,String telefone,String token ,String lastname,String password,String description,List<String> favoritPrograming) {

        User user = user_repo.findById(idUser).orElseThrow(() -> new IllegalStateException("User with this id " + idUser + " does not existe"));
                if (firstname != null && firstname.length() > 0 && !Objects.equals(user.getFirstname(), firstname)) {
                    user.setFirstname(firstname);
           
                }
                user.setAvatar(avatar);
                user.setAddess(adress);
                
                    Optional<User> userEmail = user_repo.findUserByEmail(email);
              
                    if (userEmail.isPresent() ) {

                      
                        throw new IllegalStateException( "Sorry ,this email :"+ email + " existe,you could choose another");
                    }
 
                    
                    user.setEmail(email);
                
                if (favoritPrograming != null && favoritPrograming.size() > 0
                        && !Objects.equals(user.getFavoritPrograming(), favoritPrograming)) {
                    user.setFavoritPrograming(favoritPrograming);
                 
                }
               
               
            }

    public Optional<User> getUserByName(String userName) {
       // boolean isExist = user_repo.existsByName(userName);
      
        return user_repo.findUserByName(userName);
    }
    }

       


