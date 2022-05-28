package com.life.CustomFinderMethod.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.life.CustomFinderMethod.model.User;
import com.life.CustomFinderMethod.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/api") // root Request Mapping Path
public class UserController {

	// Here We Need to create 3 EndPoints
	// first EndPoint is : To save any user into the DB
	// Second EndPoint is : To get all the avalable resource in the DB
	// Third EndPoint is : To Find or to fetch the user according to the user Id

	@Autowired
	private UserService userService;

	@GetMapping("/add")
	String addData() {
		return "jeevan";
	}

	// 1endpoint
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		userService.saveUser(user);
		return "user";
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	// Custom Api
	@GetMapping("/getUserByCityName/{city}")
	public List<User> getUserByCityName(@PathVariable String city) {
		return userService.getUserByCityName(city);
	}

	// Custom Api
	@GetMapping("/getUserByID/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	// custom
	@GetMapping("/getUserByPassword/{password}")
	public List<User> getUserByPassword(@PathVariable String password) {
		return userService.getUserByPassword(password);
	}
	
	//
	@GetMapping("/getUserByCityOrName/{name}/{city}")
	public List<User>getUserByCityOrName(@PathVariable String name, @PathVariable String city)
	{
		return userService.getUserByNameOrCity(name, city);
	}
	
	//jpqa
	@GetMapping("/getAllUserByJPQL")
	public List<User>getAllUserByJPQL()
	{
	return userService.getAllUserUsingJPQL();
	}
	
	@GetMapping("/getUserByCity/{city}")
	public List<User>getUserByCityUsingJPQL(@PathVariable  String city)
	{
		return userService.getUserByCityUsingJPQL(city);
	}
	
	@GetMapping("/getUserByCityOrNameUsingJPA/{name}/{city}")
	public List<User>getUserByCityOrNameUsingJPQL(@PathVariable String city,@PathVariable String name)
	{
		return userService.getUserByCityOrNameUsingJPQL(city, name);
	}
	
	//native
	@GetMapping("/getUsersUsingNative")
	public List<User>getUserUsingNative()
	{
	return userService.getAllUsersUsingNative();
	}
}
