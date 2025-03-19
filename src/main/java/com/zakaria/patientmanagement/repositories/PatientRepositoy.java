package com.zakaria.patientmanagement.repositories;

import com.zakaria.patientmanagement.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositoy extends JpaRepository<Patient, Long> {
}
