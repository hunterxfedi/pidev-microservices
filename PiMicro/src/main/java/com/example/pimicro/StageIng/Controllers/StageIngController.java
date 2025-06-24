package com.example.pimicro.StageIng.Controllers;

import com.example.pimicro.StageIng.Class.StageIng;
import com.example.pimicro.StageIng.Services.StageIngService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/stage-ing")
public class StageIngController {
    private final StageIngService stageIngService;

    public StageIngController(StageIngService stageIngService) {
        this.stageIngService = stageIngService;
    }

    // Submit internship documents (without setting note)
    @PostMapping(value = "/submit")


    public ResponseEntity<?> submitStage(
            @RequestParam("lettreAffectation") MultipartFile lettreAffectation,
            @RequestParam("journalStage") MultipartFile journalStage,
            @RequestParam("rapportStage") MultipartFile rapportStage) {
        try {
            StageIng stageIng = stageIngService.submitStage(lettreAffectation, journalStage, rapportStage);
            return ResponseEntity.ok(stageIng);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("File processing failed: " + e.getMessage());
        }
    }

    // Get all internships
    @GetMapping("/all")
    public ResponseEntity<List<StageIng>> getAllStages() {
        return ResponseEntity.ok(stageIngService.getAllStages());
    }

    // Update the grade (note) of the internship and validate
    @PutMapping("/{id}/grade")
    public ResponseEntity<StageIng> updateStageGrade(@PathVariable Long id, @RequestParam Double note) {
        return ResponseEntity.ok(stageIngService.updateStageGrade(id, note));
    }
    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadFile(
            @PathVariable Long id,
            @RequestParam String type) {

        byte[] data = stageIngService.downloadFile(id, type);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + type + ".pdf")
                .body(data);
    }


    // Delete an internship
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long id) {
        stageIngService.deleteStage(id);
        return ResponseEntity.noContent().build();
    }
}
