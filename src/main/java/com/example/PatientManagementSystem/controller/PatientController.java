package com.example.PatientManagementSystem.controller;


import com.example.PatientManagementSystem.service.PatientServiceImpm;
import com.example.PatientManagementSystem.entity.Patient;
import com.example.PatientManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

    private final PatientServiceImpm patientService;

    @Autowired
    public PatientController(PatientServiceImpm patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String getAllPatient2(Model model) {
        model.addAttribute("patientList", patientService.getPatientsAbove18SortedByName());
        return "index";
    }


    @GetMapping("/showAddPatientForm")
    public String addNewPatientForm(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "addPatient";
    }


    @PostMapping("/addPatient")
    public String addNewPatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "addPatient";
        }
        patientService.addPatient(patient);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable("id")int id, Model model){
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient",patient);
        return "updatePatient";
    }

    @PostMapping("/updatePatient")
    public String updateNewPatient(@ModelAttribute("patient")Patient patient){
        patientService.updatePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable("id")int id){
        patientService.deletePatient(id);
        return "redirect:/";
    }

    @PostMapping("/searchPatient")
    public String searchPatientById(@RequestParam String patientName, Model model) {
        model.addAttribute("patientList", patientService.searchPatientByName(patientName));
        return "index";
    }

    @PostMapping("/searchPatientByName")
    public String searchPatientByName(@RequestParam String patientName, Model model){

        model.addAttribute("patientList",patientService.searchPatientByName(patientName));
        return "index";

    }







}