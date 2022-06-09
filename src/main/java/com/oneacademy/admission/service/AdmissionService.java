package com.oneacademy.admission.service;

import com.oneacademy.admission.entity.StudentEntity;
import com.oneacademy.admission.model.StudentModel;

import java.util.List;

public interface AdmissionService {
    StudentEntity newAdmission(StudentModel studentModel);

    List<StudentEntity> getAllStudents();

    StudentEntity deleteAdmission(Long studentId);
}
