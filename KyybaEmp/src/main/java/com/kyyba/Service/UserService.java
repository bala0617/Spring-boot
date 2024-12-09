package com.kyyba.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyyba.Entity.User;
import com.kyyba.Entity.UserDetails;
import com.kyyba.Repository.UserRepository;
import com.kyyba.Repository.User_DetailsRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class UserService 
{
 @Autowired 
 UserRepository UserRepo;
 @Autowired 
 User_DetailsRepository User_DetailsRepo;
 
public List<User> getAllEmp() 
{
	return UserRepo.findAll();
}

public User getEmp(long loginId) 
{
	return UserRepo.findById(loginId).orElse(null);
}

public User createEmp(User user) 
{
	return UserRepo.save(user);
}

public User updateEmp(long loginId, User user) 
{
	user.setLoginId(loginId);
	Optional<User> empUser = UserRepo.findById(loginId);
	if(!empUser.isPresent())
	{
	  throw new EntityNotFoundException("Employee with ID" +"Not Found!!!");
	}
	User existingUser = empUser.get();
	

	UserDetails UserDetail = user.getUserDetails();
	
	if(user.getEmail() == null)
	{
		user.setEmail(existingUser.getEmail());
	}
	if(user.getPassword() == null)
	{
		user.setPassword(existingUser.getPassword());
	}
	
	if(user.getUserDetails() == null)
	{
		user.setUserDetails(existingUser.getUserDetails());
	}
	
	
	if(UserDetail.getId() == null)
	{
		UserDetail.setId(existingUser.getUserDetails().getId());
		user.setUserDetails(UserDetail);
	}
	if(UserDetail.getFirstName() == null)
	{
	  UserDetail.setFirstName(existingUser.getUserDetails().getFirstName());
	  user.setUserDetails(UserDetail);
	}
	if(UserDetail.getLastName() == null)
	{
		UserDetail.setLastName(existingUser.getUserDetails().getLastName());
		user.setUserDetails(UserDetail);
	}
	if(UserDetail.getAge() == null)
	{
		UserDetail.setAge(existingUser.getUserDetails().getAge());
		user.setUserDetails(UserDetail);
	}
	if(UserDetail.getGender() == null)
	{
		UserDetail.setGender(existingUser.getUserDetails().getGender());
		user.setUserDetails(UserDetail);
	}
	if(UserDetail.getAddress() == null)
	{
		UserDetail.setAddress(existingUser.getUserDetails().getAddress());
		user.setUserDetails(UserDetail);
	}
	return UserRepo.save(user);
}

public String deleteEmp(long loginId) 
{
	UserRepo.deleteById(loginId);
	return "Deleted successfully!!!";
}

}
