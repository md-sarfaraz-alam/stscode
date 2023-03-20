package com.cruddemo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruddemo.entities.Student;
import com.cruddemo.repositories.StudentRepository;

@SpringBootTest
class CrudDemo3ApplicationTests {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Test
	void saveOneStudentInformation() {
		Student s=new Student();
		s.setName("stallin");
		s.setCourse("java");
		s.setFee(10000);
		studentRepo.save(s);
	}
	
	@Test
	void deleteOneStudent() {
		studentRepo.deleteById(3L);
	}
	
	@Test
	void grtIOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		System.out.println(student.getId()); 
		System.out.println(student.getCourse()); 
		System.out.println(student.getFee());
		System.out.println(student.getName()); 
	}
	
	@Test
	void updateOneStudentInformation() {
		Optional<Student> findById = studentRepo.findById(2L);
		Student student = findById.get();
		student.setCourse("testing");
		
		studentRepo.save(student);
	}
	
	@Test
	void getAllStudent() {
		Iterable<Student> findAll = studentRepo.findAll();
		for (Student student : findAll) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());

		}
		}
	

}
