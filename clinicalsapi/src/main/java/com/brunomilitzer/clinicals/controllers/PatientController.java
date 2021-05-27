package com.brunomilitzer.clinicals.controllers;

import com.brunomilitzer.clinicals.entities.ClinicalData;
import com.brunomilitzer.clinicals.entities.Patient;
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
public class PatientController {

    private final PatientRepository repository;

    Map<String, String> filters = new HashMap<>();

    @Autowired
    public PatientController(final PatientRepository repository) {

        this.repository = repository;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> getPatients() {

        return this.repository.findAll();
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") final Long id) {

        return this.repository.findById(id).get();
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public Patient savePatient(@RequestBody final Patient patient) {

        return this.repository.save(patient);
    }

    @RequestMapping(value = "/patients/analyze/{id}", method = RequestMethod.GET)
    public Patient analyze(@PathVariable("id") final Long id) {

        final Patient patient = this.repository.findById(id).get();

        final List<ClinicalData> clinicalData = patient.getClinicalData();

        final List<ClinicalData> clonedClinicalData = new ArrayList<>(clinicalData);

        BMICalculator.calculateBMI(clinicalData, clonedClinicalData, this.filters);

        this.filters.clear();

        return patient;
    }

}
