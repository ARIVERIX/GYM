package com.example.restapiservice.controller;

import com.example.restapiservice.DTO.TrainerDTO;
import com.example.restapiservice.entity.Trainer;
import com.example.restapiservice.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerController(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @GetMapping
    public List<TrainerDTO> getAllTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TrainerDTO getTrainerById(@PathVariable Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
        return convertToDTO(trainer);
    }

    @PostMapping
    public TrainerDTO createTrainer(@RequestBody TrainerDTO trainerDTO) {
        Trainer trainer = convertToEntity(trainerDTO);
        Trainer savedTrainer = trainerRepository.save(trainer);
        return convertToDTO(savedTrainer);
    }

    @PutMapping("/{id}")
    public TrainerDTO updateTrainer(@PathVariable Long id, @RequestBody TrainerDTO updatedTrainerDTO) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));

        trainer.setFirstName(updatedTrainerDTO.getFirstName());
        trainer.setLastName(updatedTrainerDTO.getLastName());
        trainer.setAge(updatedTrainerDTO.getAge());
        trainer.setGender(updatedTrainerDTO.getGender());
        trainer.setContactNumber(updatedTrainerDTO.getContactNumber());

        Trainer updatedTrainer = trainerRepository.save(trainer);
        return convertToDTO(updatedTrainer);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));

        trainerRepository.delete(trainer);
    }

    // Методы конвертации между DTO и сущностью
    private TrainerDTO convertToDTO(Trainer trainer) {
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setTrainerId(trainer.getTrainerId());
        trainerDTO.setFirstName(trainer.getFirstName());
        trainerDTO.setLastName(trainer.getLastName());
        trainerDTO.setAge(trainer.getAge());
        trainerDTO.setGender(trainer.getGender());
        trainerDTO.setContactNumber(trainer.getContactNumber());
        return trainerDTO;
    }

    private Trainer convertToEntity(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer();
        trainer.setTrainerId(trainerDTO.getTrainerId());
        trainer.setFirstName(trainerDTO.getFirstName());
        trainer.setLastName(trainerDTO.getLastName());
        trainer.setAge(trainerDTO.getAge());
        trainer.setGender(trainerDTO.getGender());
        trainer.setContactNumber(trainerDTO.getContactNumber());
        return trainer;
    }
}
