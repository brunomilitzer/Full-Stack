package com.brunomilitzer.clinicals.utils;

import com.brunomilitzer.clinicals.entities.ClinicalData;

import java.util.List;
import java.util.Map;

public class BMICalculator {

    public static void calculateBMI(final List<ClinicalData> clinicalData, final List<ClinicalData> clonedClinicalData, final Map<String, String> filters) {

        clonedClinicalData.stream().filter(data -> data.getComponentName().equals("hw")).forEach(component -> {

            if (filters.containsKey(component.getComponentName())) {
                clinicalData.remove(component);
            } else {
                filters.put(component.getComponentName(), null);
            }

            final String[] heightAndWeight = component.getComponentValue().split("/");

            if (heightAndWeight.length > 1) {
                final float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
                final float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
                final ClinicalData bmiData = new ClinicalData();
                bmiData.setComponentName("bmi");
                bmiData.setComponentValue(Float.toString(bmi));
                clinicalData.add(bmiData);
            }
        });
    }

}
