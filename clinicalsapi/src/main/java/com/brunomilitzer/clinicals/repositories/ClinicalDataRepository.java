package com.brunomilitzer.clinicals.repositories;

import com.brunomilitzer.clinicals.entities.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {

    List<ClinicalData> findByPatientIdAndComponentNameOrderByMeasuredDateTime(Long patientId, String componentName);

}
