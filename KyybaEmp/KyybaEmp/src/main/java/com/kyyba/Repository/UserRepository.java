package com.kyyba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyyba.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
