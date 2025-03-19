package com.zakaria.patientmanagement.web;

import com.zakaria.patientmanagement.entities.Patient;
import com.zakaria.patientmanagement.repositories.PatientRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class patientController {
    private PatientRepositoy patientRepositoy;

    @GetMapping("/index")
    public String index(Model model){
        List<Patient> patientList = patientRepositoy.findAll();
        model.addAttribute("patientList", patientList);
        return "patients";
    }
}
