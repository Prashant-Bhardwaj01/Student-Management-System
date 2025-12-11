package com.devops.studentmgmt.service;

import com.devops.studentmgmt.exception.StudentNotFoundException;
import com.devops.studentmgmt.model.Student;
import com.devops.studentmgmt.repository.StudentRepository;
import com.devops.studentmgmt.util.IdGenerator;

import java.util.List;

public class StudentService {

    private final StudentRepository repo = new StudentRepository();

    public Student createStudent(String name, int age) {
        return repo.save(new Student(IdGenerator.generate(), name, age));
    }

    public Student getStudent(String id) {
        Student s = repo.findById(id);
        if (s == null) throw new StudentNotFoundException(id);
        return s;
    }

    public List<Student> getAllStudents() { return repo.findAll(); }

    public void deleteStudent(String id) {
        if (repo.findById(id) == null) throw new StudentNotFoundException(id);
        repo.deleteById(id);
    }
    public void updateStudent(String id, String name, int age) {
    if (repo.findById(id) == null) throw new StudentNotFoundException(id);
    repo.updateStudent(id, name, age);
}

}