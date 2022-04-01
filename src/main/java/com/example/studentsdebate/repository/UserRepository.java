package com.example.studentsdebate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.studentsdebate.entity.Students;
import com.example.studentsdebate.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
	
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
		// Using JPQL queries - https://www.baeldung.com/spring-data-jpa-query
	    @Query("SELECT u FROM User u WHERE u.username = ?1")
	    public User getUserByUsername(String username);

}
