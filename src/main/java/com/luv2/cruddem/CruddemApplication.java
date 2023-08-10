package com.luv2.cruddem;

import com.luv2.cruddem.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowDeleted=studentDAO.deleteAll();
		System.out.println(numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id: primary key
		int studentId=1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to scooby
		System.out.println("updating student....");
		myStudent.setFirstName("scooby");
		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("updated student " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		//get list of student
		List<Student>theStudents =studentDAO.findByLastName("Doe");

		//display list of student
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//display a list
		List<Student> theStudents = studentDAO.findAll();

		//display list of student
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("creating student object");
		Student tempStudent = new Student("Mary", "Tobi", "my@gmail.com");
		//save the student
		System.out.println("saving the object");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student . gGenerated: " + theId);

		//retrieve student based on the id
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create Multiple students
		System.out.println("Creating 3 student objetcs...");
		Student tempStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
		Student tempStudent2 = new Student("Mary", "public", "mary@gmail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonitaapplebum@gmail.com");

		// save student object
		System.out.println("saving student object");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "Paul@luv2code.com");

		//save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}

}
