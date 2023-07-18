package com.example.restapiservice.controller;

import com.example.restapiservice.DTO.AdministratorDTO;
import com.example.restapiservice.entity.Administrator;
import com.example.restapiservice.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {
    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorController(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @GetMapping
    public List<AdministratorDTO> getAllAdministrators() {
        List<Administrator> administrators = administratorRepository.findAll();
        return administrators.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AdministratorDTO getAdministratorById(@PathVariable Long id) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrator not found with id: " + id));
        return convertToDTO(administrator);
    }

    @PostMapping
    public AdministratorDTO createAdministrator(@RequestBody AdministratorDTO administratorDTO) {
        Administrator administrator = convertToEntity(administratorDTO);
        Administrator savedAdministrator = administratorRepository.save(administrator);
        return convertToDTO(savedAdministrator);
    }

    @PutMapping("/{id}")
    public AdministratorDTO updateAdministrator(@PathVariable Long id, @RequestBody AdministratorDTO updatedAdministratorDTO) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrator not found with id: " + id));

        administrator.setFirstName(updatedAdministratorDTO.getFirstName());
        administrator.setLastName(updatedAdministratorDTO.getLastName());
        administrator.setAge(updatedAdministratorDTO.getAge());
        administrator.setGender(updatedAdministratorDTO.getGender());
        administrator.setContactNumber(updatedAdministratorDTO.getContactNumber());

        Administrator updatedAdministrator = administratorRepository.save(administrator);
        return convertToDTO(updatedAdministrator);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministrator(@PathVariable Long id) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrator not found with id: " + id));

        administratorRepository.delete(administrator);
    }

    // Методы конвертации между DTO и сущностью
    private AdministratorDTO convertToDTO(Administrator administrator) {
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setAdministratorId(administrator.getAdministratorId());
        administratorDTO.setFirstName(administrator.getFirstName());
        administratorDTO.setLastName(administrator.getLastName());
        administratorDTO.setAge(administrator.getAge());
        administratorDTO.setGender(administrator.getGender());
        administratorDTO.setContactNumber(administrator.getContactNumber());
        return administratorDTO;
    }

    private Administrator convertToEntity(AdministratorDTO administratorDTO) {
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorDTO.getAdministratorId());
        administrator.setFirstName(administratorDTO.getFirstName());
        administrator.setLastName(administratorDTO.getLastName());
        administrator.setAge(administratorDTO.getAge());
        administrator.setGender(administratorDTO.getGender());
        administrator.setContactNumber(administratorDTO.getContactNumber());
        return administrator;
    }
}
