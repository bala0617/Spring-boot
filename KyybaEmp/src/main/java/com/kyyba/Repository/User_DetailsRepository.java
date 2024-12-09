package com.kyyba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyyba.Entity.UserDetails;

public interface User_DetailsRepository extends JpaRepository<UserDetails, Long>
{
  
}
