package com.jeffiprogrammer.studentcrudapp.services;


import com.jeffiprogrammer.studentcrudapp.entities.Student;
import com.jeffiprogrammer.studentcrudapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student createStudentService(Student studentData) {
        return repo.save(studentData);
    }

    public List<Student> getAllStudentsService() {
        return repo.findAll();
    }

    public Student getStudentByIDService(Long studentID) {
        return repo.findById(studentID).get();
    }

    public String updateStudentService(Long studentID, Student studentData) {
        var oldStudent = repo.findById(studentID).get();
        if (oldStudent != null) {
            oldStudent.setFullname(studentData.getFullname());
            oldStudent.setEmail(studentData.getEmail());
            oldStudent.setAge(studentData.getAge());
            repo.save(oldStudent);
            return String.format("Student by ID: %s updated!", studentID);
        }
        return String.format("Student by ID: %s not found!", studentID);
    }

    public String deleteStudentService(Long studentID) {
        var student = repo.findById(studentID).get();
        if (student != null) {
            repo.deleteById(studentID);
            return String.format("Student by ID: %s deleted!", studentID);
        }
        return String.format("Student by ID: %s not found!", studentID);

    }
}
