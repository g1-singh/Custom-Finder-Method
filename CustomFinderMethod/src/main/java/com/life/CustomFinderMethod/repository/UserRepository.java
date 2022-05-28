package com.life.CustomFinderMethod.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.life.CustomFinderMethod.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	//custm user define
	//I want to fetch data according to the name,according to the password,according to the id
	//So we can write a custom user define methods
	
	//feth data according to your city
	//here we have define our own user define method or the custom finder method according to our requirment
	//Now I will find the user according to the city name
	//select * from user where city = "anything";
	public List<User>findByCity(String city);
	public Optional<User>findById(Integer id);
	public List<User>findByPassword(String password);
	public List<User>findByNameOrCity(String name, String city);
	
	//we can integrate the JPQL(similar to the HQL) and native Query
	//custom query
	@Query("select u from User u")
	public List<User>getAllUserUsingJPAQL();
	
	//param bind with the c 
	@Query("select u from User u where u.city=:c")
	public List<User>getUserByCityUsingJPAQL(@Param("c") String city);
	
	@Query("select u from User u where u.city=:c or u.name=:n")
	public List<User>getUserByCityOrNameUsingJPAQL(@Param("c") String city,@Param("n")String name);

	//native Queries
	@Query(value = "select * from user_table", nativeQuery=true)
	public List<User>getAllUsersUsingNativeQuery();
}
