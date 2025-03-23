package com.zakaria.patientmanagement.web;

import com.zakaria.patientmanagement.entities.Patient;
import com.zakaria.patientmanagement.repositories.PatientRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepositoy patientRepositoy;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page",defaultValue = "0") int page,
                                    @RequestParam(name="size", defaultValue = "4") int size,
                        @RequestParam(name="keyword", defaultValue = "") String keyword
                        ){
        //List<Patient> patientList = patientRepositoy.findAll();
        //Page<Patient> pages = patientRepositoy.findAll(PageRequest.of(page,size));
        Page<Patient> pages = patientRepositoy.findByNameContains(keyword,PageRequest.of(page,size));

        model.addAttribute("patientList", pages.getContent());
        //nombre de pages
        model.addAttribute("pages",new int[pages.getTotalPages()]);
        model.addAttribute("currentPage",page);

        //save the keyword so we can show it in the frontend
        model.addAttribute("keyword",keyword);

        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepositoy.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String defaultRouting(){
        return "redirect:/index";
    }

    }
