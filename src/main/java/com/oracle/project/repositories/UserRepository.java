package com.oracle.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oracle.project.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
	Optional<User> findByUserName(String userName);
}
