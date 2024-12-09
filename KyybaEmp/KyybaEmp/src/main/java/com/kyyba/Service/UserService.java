package com.kyyba.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyyba.Entity.User;
import com.kyyba.Entity.User_Details;
import com.kyyba.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService 
{
 @Autowired 
 UserRepository UserRepo;
 
public List<User> getAllEmp() 
{
	return UserRepo.findAll();
}

public User getEmp(long id) 
{
	return UserRepo.findById(id).orElse(null);
}

public User createEmp(User user) 
{
	return UserRepo.save(user);
}

public User updateEmp(long id, User user) 
{
	user.setId(id);
	
	Optional<User> empOpt = UserRepo.findById(id);
	if(!empOpt.isPresent())
	{
	  throw new EntityNotFoundException("Employee with ID" +"Not Found!!!");
	}
	User existingUser = empOpt.get();
	
	if(user.getEmail() == null)
	{
		user.setEmail(existingUser.getEmail());
	}
	
	if(user.getUserDetails() == null)
	{
		user.setUserDetails(existingUser.getUserDetails());
	}
	else
	{
		User_Details newUser_Details = user.getUserDetails();
		
    	newUser_Details.setId(existingUser.getUserDetails().getId());
////		newUser_Details.setFirstName(existingUser.getUser_details().getFirstName());
////		newUser_Details.setLastName(existingUser.getUser_details().getLastName());
////		newUser_Details.setAge(existingUser.getUser_details().getAge());
////		newUser_Details.setGender(existingUser.getUser_details().getGender());
////		newUser_Details.setAddress(existingUser.getUser_details().getAddress());
	
		user.setUserDetails(newUser_Details);
	}	
	return UserRepo.save(user);
}

public String deleteEmp(long id) 
{
	UserRepo.deleteById(id);
	return "Deleted successfully!!!";
}

}
