package com.example.PatientManagementSystem.service;

import com.example.PatientManagementSystem.entity.Patient;

import java.util.List;

public interface PatientService {

    public void  addPatient(Patient patient);

    public List<Patient> getAllPatients();
    public Patient getPatientById(int id);
    public void updatePatient(Patient patient);
    public void deletePatient(int id);
    public List<Patient> getPatientsAbove18SortedByName();
    public List<Patient> searchPatientByName(String patient);

}
