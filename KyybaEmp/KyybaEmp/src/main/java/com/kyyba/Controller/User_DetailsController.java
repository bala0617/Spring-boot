package com.kyyba.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyyba.Entity.User_Details;
import com.kyyba.Service.User_DetailsService;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api1")
public class User_DetailsController 
{
 @Autowired
 User_DetailsService User_DetailsServ;
 
 @GetMapping("/GetAllEmp")
 public List<User_Details> GetAllEmp()
 {
	 return User_DetailsServ.GetAllEmp();
 }
}
