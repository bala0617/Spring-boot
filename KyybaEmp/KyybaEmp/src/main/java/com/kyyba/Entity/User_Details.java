package com.kyyba.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user_details")
public class User_Details 
{
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String firstName;
 private String lastName;
 private Long age;
 private String gender;
 private String address;
 
 @OneToOne(mappedBy = "userDetails")
 @JsonBackReference
 private User user;
}
