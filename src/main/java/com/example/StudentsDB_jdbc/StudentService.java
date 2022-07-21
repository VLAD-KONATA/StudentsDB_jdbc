package com.example.StudentsDB_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    public int addStudent(Student student){
        return studentDao.addStudent(student);
    }
    public int updateStudent(Student student){
        return studentDao.update(student);
    }
    public int deleteStudentByNo(String no){
        return studentDao.deleteStudentByNo(no);
    }
    public Student getStudentByNo(String no){
        return studentDao.getStudentByNo(no);
    }
    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
}