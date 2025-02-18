package com.example.PatientManagementSystem.repository;

import com.example.PatientManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByName(String name);

    @Query(value = "SELECT * FROM Patient WHERE age > 18 ORDER BY name", nativeQuery = true)
    List<Patient> findAllPatientsAbove18SortedByName();
}