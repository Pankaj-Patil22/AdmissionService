package com.oneacademy.admission.service;

import com.oneacademy.admission.entity.StudentEntity;
import com.oneacademy.admission.model.StudentModel;

public interface AdmissionService {
    StudentEntity newAdmission(StudentModel studentModel);
}
