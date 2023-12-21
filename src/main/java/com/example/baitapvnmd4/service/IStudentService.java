package com.example.baitapvnmd4.service;
import com.example.baitapvnmd4.model.Student;
import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    Student findById(int id);
    void update(int id,Student student);
    void remove(int id);
    List<Student> sortStudentsByAge();
    List<Student> searchStudentsByGender(String gender);
}
