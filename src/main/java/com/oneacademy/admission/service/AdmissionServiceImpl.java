package com.oneacademy.admission.service;

import com.oneacademy.admission.entity.StudentEntity;
import com.oneacademy.admission.model.StudentModel;
import com.oneacademy.admission.repository.StudentEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    private StudentEntityRepository studentEntityRepository;

    public AdmissionServiceImpl(StudentEntityRepository studentEntityRepository) {
        this.studentEntityRepository = studentEntityRepository;
    }

    @Override
    public StudentEntity newAdmission(StudentModel studentModel)
    {
        if(studentEntityRepository.existsByEmailIgnoreCase(studentModel.getEmail())){
            throw new IllegalArgumentException("Student already admitted");
        }

        StudentEntity studentEntity=StudentEntity.builder()
                .firstName(studentModel.getFirstName())
                .lastName(studentModel.getLastName())
                .email(studentModel.getEmail())
                .fieldOfStudy(studentModel.getFieldOfStudy())
                .build();

        studentEntityRepository.save(studentEntity);

        return studentEntity;
    }

    @Override
    public List<StudentEntity> getAllStudents() {

        List<StudentEntity> studentEntities=new ArrayList<StudentEntity>();
        studentEntityRepository.findAll().forEach(studentEntity -> studentEntities.add(studentEntity));

        return studentEntities;
    }

    @Override
    public StudentEntity deleteAdmission(Long studentId) {

        if(!studentEntityRepository.existsById(studentId)){
            throw new IllegalArgumentException("Admission with id = "+studentId+" doesn't exist");
        }

        StudentEntity studentEntity=new StudentEntity();

        BeanUtils.copyProperties(studentEntityRepository.findByStudentId(studentId),studentEntity);

        studentEntityRepository.delete(studentEntity);

        return studentEntity;
    }


}
