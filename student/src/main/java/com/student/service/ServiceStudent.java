package com.student.service;

import com.student.exception.StudentNotFoundExeption;
import com.student.model.Students;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStudent {
    private StudentRepository studentRepository;

    @Autowired
    public ServiceStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void addStudent(Students students){
        this.studentRepository.save(students);
    }

    public List<Students> getAllStudents(){
        return this.studentRepository.findAll();
    }

    public Optional<Students> getOneStudents(Long id){
        Optional<Students> student = this.studentRepository.findById(id);
        if (!student.isPresent()){
            throw new StudentNotFoundExeption("etudent de %  existe pas"+id);
        }
        return student;
    }

    public void updateStudent(Students students, Long id){
        Optional<Students> oldstudent = this.studentRepository.findById(id);
        if (!oldstudent.isPresent()){
            throw new StudentNotFoundExeption("etudent de %  existe pas"+id);
        }
        this.studentRepository.save(students);
    }

    public void deleteStudent(Long id){
        Optional<Students> student = this.studentRepository.findById(id);
        if (!student.isPresent()){
            throw new StudentNotFoundExeption("etudent de %  existe pas"+id);
        }
        this.studentRepository.deleteById(id);
    }

}
