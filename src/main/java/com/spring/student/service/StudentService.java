package com.spring.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.student.model.Student;
import com.spring.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student registerStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public List<Student> getStudents()
	{
		return (List<Student>) studentRepository.findAll();
	}
	
	public void deleteStudent(Integer id) 
	{
		studentRepository.deleteById(id);
	}
	
	public Student updateStudent(Student student)
	{
		Integer id=student.getId();
		Student std= studentRepository.findById(id).get();
		std.setName(student.getName());
		std.setAddress(student.getAddress());
		return studentRepository.save(std);		
	}
}
