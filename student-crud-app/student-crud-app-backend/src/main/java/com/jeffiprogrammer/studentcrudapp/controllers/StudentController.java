package com.jeffiprogrammer.studentcrudapp.controllers;


import com.jeffiprogrammer.studentcrudapp.entities.Student;
import com.jeffiprogrammer.studentcrudapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService service;


    @PostMapping
    public Student createStudent(@RequestBody Student studentData){
        return service.createStudentService(studentData);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudentsService();
    }

    @GetMapping(value = "/{studentID}")
    public Student getStudentByID(@PathVariable(value = "studentID") Long studentID){
        return service.getStudentByIDService(studentID);
    }

    @PutMapping(value = "/{studentID}")
    public String updateStudent(@PathVariable(value = "studentID") Long studentID,@RequestBody Student studentData){
        return service.updateStudentService(studentID,studentData);
    }

    @DeleteMapping(value = "/{studentID}")
    public String deleteStudent(@PathVariable(value = "studentID") Long studentID){
        return service.deleteStudentService(studentID);
    }
}
