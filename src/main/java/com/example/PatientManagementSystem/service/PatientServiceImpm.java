package com.example.PatientManagementSystem.service;

import com.example.PatientManagementSystem.entity.Patient;
import com.example.PatientManagementSystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpm implements PatientService{

    private final PatientRepository patientRepository;

    public PatientServiceImpm(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }




    @Override
    public void addPatient(Patient patient)
    {

        patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients()
    {

        return patientRepository.findAll();

    }


    @Override
    public Patient getPatientById(int id)
    {
        return patientRepository.getReferenceById(id);

    }

    @Override
    public void updatePatient(Patient patient)
    {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(int id)
    {
        patientRepository.deleteById(id);
    }

//    @Override
//    public List<Patient> searchPatient(int id) {
//
//
//        return null;
//    }


    public List<Patient> searchPatientById(String name) {
        return null;
    }


    public List<Patient> searchPatientByName(String patient) {
        return patientRepository.findByName(patient);

    }

    @Override
    public List<Patient> getPatientsAbove18SortedByName() {
        return patientRepository.findAllPatientsAbove18SortedByName();
    }



}
