package com.luv2.cruddem;

import com.luv2.cruddem.entity.Student;

import java.util.List;

public interface StudentDAO {
    //saving student
    void save(Student thestudent);

    //finding the student
    Student findById(Integer id);

   // Quering the database
    List<Student>findAll();

    //querying by last name

    List<Student>findByLastName(String theLastName);

    //updating tables
    void update(Student theStudent);

    //delete a particular element
    void delete(Integer id);
     //delete all tables
    int deleteAll();
}
