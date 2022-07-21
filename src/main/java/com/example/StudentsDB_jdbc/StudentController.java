package com.example.StudentsDB_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/studentOps")
    public void studentOps(){
        Student s1 = new Student();
        s1.setNo("202201001");
        s1.setName("张三");
        s1.setSex("男");
        s1.setAge(19);
        s1.setCollege("健康学院");
        Student s2 = new Student();
        s2.setNo("202202012");
        s2.setName("李四");
        s2.setSex("女");
        s2.setAge(19);
        s2.setCollege("机械学院");
        Student s3 = new Student();
        s3.setNo("202203037");
        s3.setName("王五");
        s3.setSex("男");
        s3.setAge(20);
        s3.setCollege("光电学院");
        Student s4 = new Student();
        s4.setNo("202204017");
        s4.setName("赵六");
        s4.setSex("男");
        s4.setAge(21);
        s4.setCollege("材料学院");
        int i=studentService.addStudent(s1)+studentService.addStudent(s2)+studentService.addStudent(s3)+studentService.addStudent(s4);
        System.out.println("Add Student>>>"+i);
    }
    @GetMapping("/students")
    public ModelAndView students() {
        List<Student> students = new ArrayList<>();
        students=studentService.getAllStudents();
        ModelAndView mv = new ModelAndView();
        mv.addObject("students", students);
        mv.setViewName("students");
        return mv;
    }
}