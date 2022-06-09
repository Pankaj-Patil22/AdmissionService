package com.oneacademy.admission.repository;

import com.oneacademy.admission.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEntityRepository extends JpaRepository<StudentEntity, Long> {

    boolean existsByEmailIgnoreCase(String email);

    StudentEntity findByStudentId(Long studentId);
}