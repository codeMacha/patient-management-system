package com.sherpa.patientservice.service;

import com.sherpa.patientservice.dto.PatientResponseDTO;
import com.sherpa.patientservice.model.Patient;
import com.sherpa.patientservice.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientService patientService;

    @Test
    void getAllPatients() {

        when(patientRepository.findAll()).thenReturn(Collections.singletonList(getPatient()));

        List<PatientResponseDTO> patientResponseDTOs = patientService.getAllPatients();

        assertNotNull(patientResponseDTOs);
        assertEquals(1, patientResponseDTOs.size());
        assertEquals("Patient Name", patientResponseDTOs.get(0).getName());
        assertEquals("1991-12-10", patientResponseDTOs.get(0).getDateOfBirth());
        verify(patientRepository, times(1)).findAll();

    }

    public Patient getPatient() {
        Patient patient = new Patient();
        patient.setId(new UUID(1,1));
        patient.setName("Patient Name");
        patient.setDateOfBirth(LocalDate.of(1991,12,10));
        return patient;
    }
}