package com.geekster.DoctorAPP.repository;

import com.geekster.DoctorAPP.model.Admin;
import com.geekster.DoctorAPP.model.Doctor;
import com.geekster.DoctorAPP.model.enums.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctorRepo extends JpaRepository<Doctor,Long> {
    List<Doctor> findBySpecialization(Specialization specialization);
}
