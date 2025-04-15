package com.example.pimicro.StageIng.Services;

import com.example.pimicro.StageIng.Class.StageIng;
import com.example.pimicro.StageIng.Repositories.StageIngRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StageIngService {
    private final StageIngRepository stageIngRepository;

    public StageIngService(StageIngRepository stageIngRepository) {
        this.stageIngRepository = stageIngRepository;
    }
    public StageIng submitStage(MultipartFile lettreAffectation, MultipartFile journalStage, MultipartFile rapportStage) {
        try {
            byte[] lettreAffectationBytes = lettreAffectation.getBytes();
            byte[] journalStageBytes = journalStage.getBytes();
            byte[] rapportStageBytes = rapportStage.getBytes();

            StageIng stageIng = new StageIng();
            stageIng.setLettreAffectation(lettreAffectationBytes);
            stageIng.setJournalStage(journalStageBytes);
            stageIng.setRapportStage(rapportStageBytes);

            return stageIngRepository.save(stageIng);
        } catch (IOException e) {
            throw new RuntimeException("Failed to process uploaded files", e);
        }
    }
    public byte[] downloadFile(Long id, String type) {
        StageIng stage = stageIngRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage non trouvé"));

        return switch (type.toLowerCase()) {
            case "lettre" -> stage.getLettreAffectation();
            case "journal" -> stage.getJournalStage();
            case "rapport" -> stage.getRapportStage();
            default -> throw new RuntimeException("Type de document invalide");
        };
    }


    // Retrieve all internships
    public List<StageIng> getAllStages() {
        return stageIngRepository.findAll();
    }

    // Update the grade (note) of the internship and set validation
    public StageIng updateStageGrade(Long stageId, Double note) {
        return stageIngRepository.findById(stageId).map(stage -> {
            stage.setNote(note);

            // Check if the grade is greater than 10, then validate
            if (note > 10) {
                stage.setValide(true);
            }

            return stageIngRepository.save(stage);
        }).orElseThrow(() -> new RuntimeException("Stage not found"));
    }

    // Delete an internship entry
    public void deleteStage(Long stageId) {
        stageIngRepository.deleteById(stageId);
    }
}
