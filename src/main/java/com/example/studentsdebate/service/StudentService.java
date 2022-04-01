package com.example.studentsdebate.service;

import java.util.*;

import com.example.studentsdebate.entity.Students;

public interface StudentService {
	
    public List<Students> findAll();
    
    public Students findById(int Id);
    
    public void save(Students student);
    
    public void deleteById(int id);
    

}
