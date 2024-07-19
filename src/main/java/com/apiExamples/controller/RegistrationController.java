package com.apiExamples.controller;


import com.apiExamples.payload.RegistrationDto;
import com.apiExamples.service.RegistrationService;
import com.apiExamples.entity.Registration;
import jakarta.persistence.PostUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    //http://localhost:8081/api/v1/registration
    @PostMapping
    public ResponseEntity<RegistrationDto> addRegistration(@RequestBody RegistrationDto registrationDto) {

        RegistrationDto reg = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(reg, HttpStatus.CREATED);
    }

    //http://localhost:8081/api/v1/registration?id=
    @DeleteMapping
    public ResponseEntity<String> deleteRegistrationById(@RequestParam long id) {

        registrationService.deleteRegistrationById(id);
        return new ResponseEntity<>("Registration deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RegistrationDto> updateRegistration(@RequestParam long id, @RequestBody RegistrationDto registrationDto) {
        RegistrationDto dto = registrationService.updateRegistration(id, registrationDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations(){
       List<RegistrationDto>dtos= registrationService.getAllRegistration();

       return new ResponseEntity<>(dtos,HttpStatus.OK);
    }
}
