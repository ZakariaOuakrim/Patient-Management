package com.zakaria.patientmanagement.web;

import com.zakaria.patientmanagement.entities.Patient;
import com.zakaria.patientmanagement.repositories.PatientRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class patientController {
    private PatientRepositoy patientRepositoy;

    @GetMapping("/index")
    public String index(Model model, int page,int size){
        //List<Patient> patientList = patientRepositoy.findAll();
        Page<Patient> patientList = patientRepositoy.findAll(PageRequest.of(page,size));
        model.addAttribute("patientList", patientList.getContent());
        return "patients";
    }
}
