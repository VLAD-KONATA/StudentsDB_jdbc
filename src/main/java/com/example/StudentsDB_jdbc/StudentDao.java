package com.example.StudentsDB_jdbc;

import com.example.StudentsDB_jdbc.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO student(No,Name,Sex,Age,College) VALUES(?,?,?,?,?)" ,student.getNo(),student.getName(),student.getSex(),student.getAge(),student.getCollege());
    }
    public int update(Student student){
        return jdbcTemplate.update("UPDATE student SET Name=?,Sex=?,Age=?,College=? WHERE No=?",student.getName(),student.getSex(),student.getAge(),student.getCollege(),student.getNo());
    }
    public int deleteStudentByNo(String no){
        return jdbcTemplate.update("DELETE from student WHERE No=?",no);
    }
    public Student getStudentByNo(String no){
        return jdbcTemplate.queryForObject("select * from student where No=?",new BeanPropertyRowMapper<>(Student.class),no);
    }
    public List<Student> getAllStudents(){
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<>(Student.class));
    }
}
