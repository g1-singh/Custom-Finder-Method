package com.life.CustomFinderMethod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.life.CustomFinderMethod.model.User;
import com.life.CustomFinderMethod.repository.UserRepository;

@Service("UserService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//first second and third are predefined method in jpa repository
	
	//first we the user
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	//second we getallUsers
	public List<User>getAllUsers(){
		return  userRepository.findAll();
		
	}
	
	//Third We have GetUserById
	//here the return type is optional. it is come form the java 8.
	//and by using optional class is used to handle the  Nullpointer Excep  tion
	public Optional<User>getUserById(int id)
	{
		return userRepository.findById(id);
	}
	
	
	//This is not a predefined method 
	//This is a custom method we have define in my repository
	public List<User>getUserByCityName(String city)
	{
		return userRepository.findByCity(city);
	}
	
	//findBy id
	public Optional<User>getUserById(Integer id)
	{
		
		return userRepository.findById(id);
	}
	
	//find By Password
	public List<User>getUserByPassword(String password)
	{
		return userRepository.findByPassword(password);
	}
	
	//
	public List<User>getUserByNameOrCity(String name, String city)
	{
		return userRepository.findByNameOrCity(name, city);
	}

	//JPQL
	public List<User>getAllUserUsingJPQL()
	{
		return userRepository.getAllUserUsingJPAQL();
	}
	
	//
	public List<User>getUserByCityUsingJPQL(String city)
	{
		return userRepository.getUserByCityUsingJPAQL(city);
	}
	
	public List<User>getUserByCityOrNameUsingJPQL(String city,String name)
	{
		return userRepository.getUserByCityOrNameUsingJPAQL(city,name);
	}
	
	//native
	public List<User>getAllUsersUsingNative()
	{
		return userRepository.getAllUsersUsingNativeQuery();
	}

	}
	
 
