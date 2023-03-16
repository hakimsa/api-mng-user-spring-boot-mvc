package com.hakimsamouh.mgtapp.Users.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.hakimsamouh.mgtapp.Users.Models.User;
import com.hakimsamouh.mgtapp.Users.Services.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:39799"})

@RequestMapping(path = "/api/v1/users")
public class UserController {

	private final UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getUsers();

	}

	@GetMapping(path = "{UserId}")
	public Optional<User> getUser(@PathVariable("UserId")Long idUser) {
		return userService.getUser(idUser);

	}
	@GetMapping(path = "by/{userName}")
	public Optional<User> getUserByName(@PathVariable("userName")String userName) {
		return userService.getUserByName(userName);

	}

	@PostMapping("/save")
	public void registerNewUser(@RequestBody User user) {
		userService.addNewUser(user);

	}

@DeleteMapping(path = "{UserId}")
public void deleteUser(@PathVariable("UserId")Long idUser){
	  userService.deleteUser(idUser);


}

@PutMapping(path = "update/{UserId}")
public void updateUser(
@PathVariable("UserId")Long idUser,
@RequestBody User user)
{
userService.updateUser(idUser,user.getFirstname(),user.getLastname(),user.getAvatar(),user.getEmail(),user.getAge(),user.getFormacion(),user.getDescription(),user.getLenguage(),user.getAddess(),user.getRedes(),user.getRole(),user.getTelefon(),user.getToken(),user.getPassword(),user.getNacion(),user.getFavoritPrograming());
}
}
