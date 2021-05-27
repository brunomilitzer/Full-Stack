package com.brunomilitzer.clinicals.repositories;

import com.brunomilitzer.clinicals.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
