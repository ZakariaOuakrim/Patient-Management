package com.zakaria.patientmanagement.repositories;

import com.zakaria.patientmanagement.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface PatientRepositoy extends JpaRepository<Patient, Long> {
    //it is mandatory to add the Pageable parameter it contains metadata about the page
    Page<Patient> findByNameContains(String keyword, Pageable pageable);

    //@Query("select p from Patient p where p.name like :x")
    //Page<Patient> search(@Param("x") String keyword);
}
