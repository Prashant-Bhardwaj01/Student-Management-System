package com.devops.studentmgmt.controller;

import com.devops.studentmgmt.model.Student;
import com.devops.studentmgmt.service.StudentService;

public class StudentController {

    private final StudentService service = new StudentService();

    public Student addStudent(String name, int age) { return service.createStudent(name, age); }
    public Student getStudent(String id) { return service.getStudent(id); }
    public java.util.List<Student> getAllStudents() { return service.getAllStudents(); }
    public void deleteStudent(String id) { service.deleteStudent(id); }
public void updateStudent(String id, String name, int age) {
    service.updateStudent(id, name, age);
}
}