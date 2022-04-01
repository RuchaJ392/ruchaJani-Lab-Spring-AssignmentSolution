package com.example.studentsdebate.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentsdebate.entity.Students;



public interface StudentRepository extends JpaRepository<Students, Integer> {
	
	
	
	

//		https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example
	

}
