package com.kyyba.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyyba.Entity.User_Details;
import com.kyyba.Repository.User_DetailsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class User_DetailsService 
{
 @Autowired 
 User_DetailsRepository User_DetailsRepo;
 
 public List<User_Details> GetAllEmp() 
 {
 	return User_DetailsRepo.findAll();
 }

 public User_Details GetEmp(long id) 
 {
 	return User_DetailsRepo.findById(id).orElse(null);
 }

 public User_Details createEmp(User_Details user_details) 
 {
 	return User_DetailsRepo.save(user_details);
 }

 public User_Details updateEmp(long id, User_Details user_details) 
 {
	 user_details.setId(id);
 	
 	Optional<User_Details> empOpt = User_DetailsRepo.findById(id);
 	if(!empOpt.isPresent())
 	{
 	  throw new EntityNotFoundException("Employee with ID" +"Not Found!!!");
 	}
 	User_Details existingKyyba = empOpt.get();
 	
 	if(user_details.getFirstName() == null)
 	{
 		user_details.setFirstName(existingKyyba.getFirstName());
 	}
 	if(user_details.getLastName() == null)
 	{
 		user_details.setLastName(existingKyyba.getLastName());
 	}
 	if(user_details.getAge() == null)
 	{
 		user_details.setAge(existingKyyba.getAge());
 	}
 	if(user_details.getGender() == null)
 	{
 		user_details.setGender(existingKyyba.getGender());
 	}
 	if(user_details.getAddress() == null)
 	{
 		user_details.setAddress(existingKyyba.getAddress());
 	}
 	return User_DetailsRepo.save(user_details);
 }

 public String DeleteEmp(long id) 
 {
 	
	 User_DetailsRepo.deleteById(id);
 	return "Deleted successfully!!!";
 }
}
