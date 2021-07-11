package com.eedu.student.service;

import com.eedu.student.entity.Student;
import com.eedu.student.repository.StudentRepository;
import com.eedu.student.vo.Institution;
import com.eedu.student.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private String institutionServiceUrl = "http://INSTITUTION-SERVICE/institution/";

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Student addStudent(Student student) {
        Student s = studentRepository.save(student);
        return s;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public ResponseTemplateVO getStudentWithInstitution(Long studentId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        Optional<Student> s = getStudentById(studentId);
        if(!s.isPresent()) {
            vo.setStudent(null);
            vo.setStudent(null);
            return vo;
        }
        Student student = s.get();
        Institution institution = restTemplate.getForObject(institutionServiceUrl + student.getInstitutionCode(), Institution.class);

        vo.setStudent(student);
        vo.setInstitution(institution);
        return vo;
    }
}
