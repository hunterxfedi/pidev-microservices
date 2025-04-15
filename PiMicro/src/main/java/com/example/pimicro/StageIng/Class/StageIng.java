package com.example.pimicro.StageIng.Class;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "stages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageIng {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will auto-generate the ID for you
    private Long id;

    @Lob // Specifies the column type for binary data (BLOB in H2)
    private byte[] lettreAffectation; // Stockage en binaire

    @Lob
    private byte[] journalStage;

    @Lob
    private byte[] rapportStage;

    private boolean valide = false; // Statut de validation par l'encadrant

    private Double note; // Note attribuée par l'encadrant


}
