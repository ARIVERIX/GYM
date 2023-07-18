package com.example.restapiservice.controller;

import com.example.restapiservice.DTO.SupportDTO;
import com.example.restapiservice.entity.Support;
import com.example.restapiservice.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/supports")
public class SupportController {
    private final SupportRepository supportRepository;

    @Autowired
    public SupportController(SupportRepository supportRepository) {
        this.supportRepository = supportRepository;
    }

    @GetMapping
    public List<SupportDTO> getAllSupports() {
        List<Support> supports = supportRepository.findAll();
        return supports.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SupportDTO getSupportById(@PathVariable Long id) {
        Support support = supportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Support not found with id: " + id));
        return convertToDTO(support);
    }

    @PostMapping
    public SupportDTO createSupport(@RequestBody SupportDTO supportDTO) {
        Support support = convertToEntity(supportDTO);
        Support savedSupport = supportRepository.save(support);
        return convertToDTO(savedSupport);
    }

    @PutMapping("/{id}")
    public SupportDTO updateSupport(@PathVariable Long id, @RequestBody SupportDTO updatedSupportDTO) {
        Support support = supportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Support not found with id: " + id));

        support.setFirstName(updatedSupportDTO.getFirstName());
        support.setLastName(updatedSupportDTO.getLastName());
        support.setAge(updatedSupportDTO.getAge());
        support.setGender(updatedSupportDTO.getGender());
        support.setContactNumber(updatedSupportDTO.getContactNumber());

        Support updatedSupport = supportRepository.save(support);
        return convertToDTO(updatedSupport);
    }

    @DeleteMapping("/{id}")
    public void deleteSupport(@PathVariable Long id) {
        Support support = supportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Support not found with id: " + id));

        supportRepository.delete(support);
    }

    // Методы конвертации между DTO и сущностью
    private SupportDTO convertToDTO(Support support) {
        SupportDTO supportDTO = new SupportDTO();
        supportDTO.setSupportId(support.getSupportId());
        supportDTO.setFirstName(support.getFirstName());
        supportDTO.setLastName(support.getLastName());
        supportDTO.setAge(support.getAge());
        supportDTO.setGender(support.getGender());
        supportDTO.setContactNumber(support.getContactNumber());
        return supportDTO;
    }

    private Support convertToEntity(SupportDTO supportDTO) {
        Support support = new Support();
        support.setSupportId(supportDTO.getSupportId());
        support.setFirstName(supportDTO.getFirstName());
        support.setLastName(supportDTO.getLastName());
        support.setAge(supportDTO.getAge());
        support.setGender(supportDTO.getGender());
        support.setContactNumber(supportDTO.getContactNumber());
        return support;
    }
}
