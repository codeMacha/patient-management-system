package com.sherpa.patientservice.service;

import com.sherpa.patientservice.dto.PatientResponseDTO;
import com.sherpa.patientservice.mapper.PatientMapper;
import com.sherpa.patientservice.model.Patient;
import com.sherpa.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toPatientResponseDTO)
                .toList();
    }
}
