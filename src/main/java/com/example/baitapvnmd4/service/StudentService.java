package com.example.baitapvnmd4.service;

import com.example.baitapvnmd4.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService implements IStudentService {
    private static final Map<Integer,Student> students;

    static {
        students = new HashMap<>();
        students.put(1, new Student(1,"Trung","male",20,"Nam Dinh"));
        students.put(2, new Student(2,"Loan","female",19,"Thai Binh"));
        students.put(3, new Student(3,"Nam","male",23,"Ha Noi"));
        students.put(4, new Student(4,"Trang","female",21,"Ho Chi Minh"));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(),student);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(id,student);
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }

    @Override
    public List<Student> sortStudentsByAge() {
        List<Student> sortedStudents = students.values()
                .stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());
        return sortedStudents;
    }

    @Override
    public List<Student> searchStudentsByGender(String gender) {
        List<Student> searchStudent = new ArrayList<>();
        for (Student student:students.values()) {
            if (student.getGender().equals(gender)){
                searchStudent.add(student);
            }
        }
        return searchStudent;
    }
}
