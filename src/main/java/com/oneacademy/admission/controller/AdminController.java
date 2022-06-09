package com.oneacademy.admission.controller;


import com.oneacademy.admission.entity.StudentEntity;
import com.oneacademy.admission.model.StudentModel;
import com.oneacademy.admission.service.AdmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdmissionService admissionService;

    public AdminController(AdmissionService admissionService)
    {
        this.admissionService=admissionService;
    }

    @PostMapping("/new-admission")
    public String newAdmission(@RequestBody StudentModel studentModel)
    {
        try {
            StudentEntity studentEntity=admissionService.newAdmission(studentModel);
        }

        catch (Exception e)
        {
            return e.getLocalizedMessage();
        }
        return "Success";
    }

    @GetMapping("/all-admissions")
    public List<StudentEntity> getAllStudents()
    {
        return admissionService.getAllStudents();
    }

    @DeleteMapping("/delete-admission/{studentId}")
    public String deleteAdmission(@PathVariable("studentId") long studentId)
    {
        try {
            StudentEntity studentEntity=admissionService.deleteAdmission(studentId);
        }
        catch (Exception e)
        {
            return e.getLocalizedMessage();
        }

        return "Success";
    }


}
