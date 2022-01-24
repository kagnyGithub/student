package com.student.controller;

import com.student.model.Students;
import com.student.service.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/rest", name = "api_student_")
public class StudentController {
    private ServiceStudent serviceStudent;

    @Autowired
    public StudentController(ServiceStudent serviceStudent) {
        this.serviceStudent = serviceStudent;
    }

    @PostMapping(path = "/students", name = "create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Students students){
        serviceStudent.addStudent(students);
    }

    @GetMapping(path = "students", name = "getstudents")
    @ResponseStatus(HttpStatus.OK)
    public List<Students> getAllStudents(){
        return serviceStudent.getAllStudents();
    }

    @GetMapping(path = "student/{id}", name = "getOneStudent")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Students> getOneStudent(@PathVariable Long id){
        return this.serviceStudent.getOneStudents(id);
    }

    @PutMapping(path = "students/{id}", name = "update")
    @ResponseStatus(HttpStatus.OK)
    public  void update(@RequestBody Students students, @PathVariable Long id){
        this.serviceStudent.updateStudent(students,id);
    }

    @DeleteMapping(path = "students/{id}", name = "delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.serviceStudent.deleteStudent(id);
    }


}
