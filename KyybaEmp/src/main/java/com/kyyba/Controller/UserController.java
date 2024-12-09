package com.kyyba.Controller;

import java.util.List;

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

import com.kyyba.Entity.User;
import com.kyyba.Service.UserService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController 
{
 @Autowired
 UserService UserServ;
 
 @GetMapping("/getAllEmp")
 public List<User> getAllEmp()
 {
	 return UserServ.getAllEmp();
 }
 
 @GetMapping("/getEmp/{loginId}")
 public User getEmp(@PathVariable long loginId)
 {
	 return UserServ.getEmp(loginId);
 }
 
 @PostMapping("/addEmp")
 public User createEmp(@RequestBody User user)
 {
	 return UserServ.createEmp(user);
 }
 
 @PutMapping("/updateEmp/{loginId}")
 public User updateEmp(@PathVariable long loginId,@RequestBody User user)
 {
	 return UserServ.updateEmp(loginId,user);
 }
 
 @DeleteMapping("/deleteEmp/{loginId}")
 public String deleteEmp(@PathVariable long loginId)
 {
	 return UserServ.deleteEmp(loginId);
 }
}
