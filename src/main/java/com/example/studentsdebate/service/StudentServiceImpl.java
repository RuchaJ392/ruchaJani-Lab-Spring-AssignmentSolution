package com.example.studentsdebate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.studentsdebate.entity.Students;
import com.example.studentsdebate.repository.StudentRepository;

import java.util.*;



@Service
public class StudentServiceImpl implements StudentService {
	
	
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	@Transactional
	public List<Students> findAll() {
		// TODO Auto-generated method stub
		List<Students> student = studentRepository.findAll();
		return student;
	}

	@Override
	@Transactional
	public Students findById(int Id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(Id).get();
	}

	@Override
	@Transactional
	public void save(Students student) {
		studentRepository.save(student);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		studentRepository.deleteById(id);
		
	}
	
	
	

}
