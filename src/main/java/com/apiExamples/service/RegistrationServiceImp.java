package com.apiExamples.service;

import com.apiExamples.entity.Registration;
import com.apiExamples.payload.RegistrationDto;
import com.apiExamples.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImp implements RegistrationService{


    private final RegistrationRepository registrationRepository;

    public RegistrationServiceImp(RegistrationRepository registrationRepository){
        this.registrationRepository=registrationRepository;
    }



    @Override
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
       Registration registration= mapToEntity(registrationDto);
        Registration saveEntity = registrationRepository.save(registration);
        RegistrationDto dto=mapToEntity(saveEntity);
        dto.setMessage("Registration");
        return dto;

    }

    @Override
    public void deleteRegistrationById(long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public RegistrationDto updateRegistration(long id, RegistrationDto registrationDto) {
        Optional<Registration> opReg = registrationRepository.findById(id);
        Registration registration=opReg.get();
        registration.setName(registrationDto.getName());
        registration.setEmail(registrationDto.getEmail());
        registration.setMobile_no(registrationDto.getMobile_no());
        Registration saveEntity=registrationRepository.save(registration);
        RegistrationDto dto=mapToEntity(registration);
        return dto;
    }

    @Override
    public List<RegistrationDto> getAllRegistration() {
        List<Registration>registrations =registrationRepository.findAll();
      List<RegistrationDto> registrationDtos= registrations.stream().map(r ->mapToEntity(r)).collect(Collectors.toList());
        return registrationDtos;
    }

    Registration mapToEntity(RegistrationDto dto){
        Registration entity = new Registration();
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setMobile_no(dto.getMobile_no());
        return entity;
    }

    RegistrationDto mapToEntity(Registration registration){
        RegistrationDto dto=new RegistrationDto();
        dto.setId(registration.getId());
        dto.setEmail(registration.getEmail());
        dto.setName(registration.getName());
        dto.setMobile_no(registration.getMobile_no());
        return dto;
    }




}
