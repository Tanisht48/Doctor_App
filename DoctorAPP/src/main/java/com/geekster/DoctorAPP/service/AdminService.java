package com.geekster.DoctorAPP.service;


import com.geekster.DoctorAPP.model.Admin;
import com.geekster.DoctorAPP.model.Doctor;
import com.geekster.DoctorAPP.model.Patient;
import com.geekster.DoctorAPP.model.enums.Gender;
import com.geekster.DoctorAPP.model.enums.Specialization;
import com.geekster.DoctorAPP.repository.IAdminRepo;
import com.geekster.DoctorAPP.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private PatientService patientService;

    @Autowired
    private IAdminRepo iAdminRepo;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private  AppointmentService appointmentService;

    public List<Patient> getAllPatients() {
        return  patientService.getAllPatients();
    }

    public List<Patient> getAllPatientsSameGender(Gender patientGender) {

        return patientService.findByPatientGender(patientGender);
    }

    public String addAdmin(Admin admin) {
        if(iAdminRepo.existsById(admin.getAdminId()))
        {
            return "admin already registered";
        }
        try {
            String encryptedPass = PasswordEncrypter.encryptPassword(admin.getAdminPassword());
            admin.setAdminPassword(encryptedPass);
            iAdminRepo.save(admin);
            return "New Admin Registered";
        }
        catch (Exception e)
        {
            return "Internal Error Occurred";
        }

    }

    public boolean adminAuthenticationService(String adminEmail, String adminPassword) {
        Admin admin = iAdminRepo.findFirstByAdminEmail(adminEmail);
        if(admin!=null) {
            try {
                String encryptPass = PasswordEncrypter.encryptPassword(adminPassword);
                return admin.getAdminPassword().equals(encryptPass);
            } catch (Exception e) {
                throw new RuntimeException("Internal Error occurred");
            }
        }
        else
            return false;
    }

    public List<Doctor> getAllDoctorsSameType(Specialization specialization) {

        return doctorService.getAllDoctorsSameType(specialization);

    }

    public String rescheduleAppointment(Long appointmentId, LocalDateTime reschedule) {
        return appointmentService.rescheduleAppointment(appointmentId,reschedule);
    }
}
