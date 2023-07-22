package com.geekster.DoctorAPP.controller;


import com.geekster.DoctorAPP.model.Admin;
import com.geekster.DoctorAPP.model.Doctor;
import com.geekster.DoctorAPP.model.Patient;
import com.geekster.DoctorAPP.model.enums.Gender;
import com.geekster.DoctorAPP.model.enums.Specialization;
import com.geekster.DoctorAPP.service.AdminService;
import jakarta.security.auth.message.AuthException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Validated
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("admin")
    public String addAdmin(@RequestBody @Valid Admin admin){
        return adminService.addAdmin(admin);
    }

    @GetMapping("patients")
    List<Patient> getAllPatients(@RequestParam String adminEmail ,@RequestParam String adminPassword)
    {
        if(adminService.adminAuthenticationService(adminEmail,adminPassword)) {
            return adminService.getAllPatients();
        }
        throw new RuntimeException("Not valid Credentials");
    }

    @GetMapping("patients/Gender")
    List<Patient>getAllPatientsSameGender(@RequestParam Gender patientGender,@RequestParam String adminEmail ,@RequestParam String adminPassword){
        if(adminService.adminAuthenticationService(adminEmail,adminPassword)) {
            return adminService.getAllPatientsSameGender(patientGender);
        }
        throw new RuntimeException("Not valid Credentials");
    }
    @GetMapping("doctors/specialization")
    List<Doctor>getAllPatientsSameGender(@RequestParam Specialization specialization, @RequestParam String adminEmail , @RequestParam String adminPassword){
        if(adminService.adminAuthenticationService(adminEmail,adminPassword)) {
            return adminService.getAllDoctorsSameType(specialization);
        }
        throw new RuntimeException("Not valid Credentials");
    }

    @PutMapping("reschedule")
    public String rescheduleAppointment(@RequestParam LocalDateTime reschedule, @RequestParam Long appointmentId, @RequestParam String adminEmail , @RequestParam String adminPassword){
        if(adminService.adminAuthenticationService(adminEmail,adminPassword)) {
            return adminService.rescheduleAppointment(appointmentId,reschedule);
        }
        return ("Not valid Credentials");

    }
}
