package com.kyyba.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
@Table(name = "user")
public class User 
{
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long loginId;
 private String email;
 private String password;
 
 @OneToOne(cascade = CascadeType.ALL)
 @JsonManagedReference
 private UserDetails userDetails;
}
