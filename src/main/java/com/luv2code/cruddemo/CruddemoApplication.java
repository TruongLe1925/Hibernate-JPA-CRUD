package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			creatStudent(studentDAO);
			findID(studentDAO);
		};
	}

	private void findID(StudentDAO studentDAO) {
		System.out.println("Create new Student");
		Student newStudent = new Student("em","Ceo","Peomteo@gmail.com");
		studentDAO.save(newStudent);
		int findID = newStudent.getId();
		System.out.println("id is " + findID);
		Student studentByiD = studentDAO.findStudentByID(findID);
		System.out.println(studentByiD);
	}

	private void creatStudent(StudentDAO studentDAO) {
		Student firstStudent = new Student("Truong","Le","lephuoctruong@gmail.com");
		studentDAO.save(firstStudent);
	}
}
