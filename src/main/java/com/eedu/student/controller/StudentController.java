package com.eedu.student.controller;

import com.eedu.student.entity.Student;
import com.eedu.student.service.StudentService;
import com.eedu.student.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
        log.info("Student: " + student);

        return studentService.addStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getStudentWithInstitution(@PathVariable("id") Long studentId) {
        log.info("=========StudentController: getStudentWithInstitution ===> studentId: " + studentId);
        return studentService.getStudentWithInstitution(studentId);
    }
}
