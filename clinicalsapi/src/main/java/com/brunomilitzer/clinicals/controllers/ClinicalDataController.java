package com.brunomilitzer.clinicals.controllers;

import com.brunomilitzer.clinicals.dtos.ClinicalDataRequest;
import com.brunomilitzer.clinicals.entities.ClinicalData;
import com.brunomilitzer.clinicals.entities.Patient;
import com.brunomilitzer.clinicals.repositories.ClinicalDataRepository;
import com.brunomilitzer.clinicals.repositories.PatientRepository;
import com.brunomilitzer.clinicals.utils.BMICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {

    private final ClinicalDataRepository clinicalDataRepository;

    private final PatientRepository patientRepository;

    Map<String, String> filters = new HashMap<>();

    @Autowired
    public ClinicalDataController(final ClinicalDataRepository clinicalDataRepository, final PatientRepository patientRepository) {

        this.clinicalDataRepository = clinicalDataRepository;
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "/clinicals", method = RequestMethod.POST)
    public ClinicalData saveClinicalData(@RequestBody final ClinicalDataRequest request) {

        final Patient patient = this.patientRepository.findById(request.getPatientId()).get();

        final ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);

        return this.clinicalDataRepository.save(clinicalData);
    }

    @RequestMapping(value = "/clinicals/{patientId}/{componentName}", method = RequestMethod.GET)
    public List<ClinicalData> getClinicalData(@PathVariable("patientId") final Long patientId, @PathVariable("componentName") String componentName) {

        if (componentName.equals("bmi")) {
            componentName = "hw";
        }

        final List<ClinicalData> clinicalData = this.clinicalDataRepository.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId, componentName);

        final List<ClinicalData> clonedClinicalData = new ArrayList<>(clinicalData);

        BMICalculator.calculateBMI(clinicalData, clonedClinicalData, this.filters);

        return clinicalData;
    }

}
