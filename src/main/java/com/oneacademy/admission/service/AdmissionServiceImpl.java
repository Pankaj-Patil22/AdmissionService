package com.oneacademy.admission.service;

import com.oneacademy.admission.entity.StudentEntity;
import com.oneacademy.admission.model.StudentModel;
import com.oneacademy.admission.repository.StudentEntityRepository;
import org.springframework.stereotype.Service;

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


}
