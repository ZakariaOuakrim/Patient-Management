package com.zakaria.patientmanagement;

import com.zakaria.patientmanagement.entities.Patient;
import com.zakaria.patientmanagement.repositories.PatientRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientManagementApplication implements CommandLineRunner {

    @Autowired
    private PatientRepositoy patientRepositoy;

    public static void main(String[] args) {
        SpringApplication.run(PatientManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //patientRepositoy.save(new Patient(null,"Zakaria",new Date(),true,10));
        //patientRepositoy.save(new Patient(null,"Hassan",new Date(),false,20));
        //patientRepositoy.save(new Patient(null,"Ali",new Date(),true,30));

    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
