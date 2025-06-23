import { Component, OnInit } from '@angular/core';
import { StageIng, StageIngService } from 'src/app/services/stage-ing.service';

@Component({
  selector: 'app-stage-ing',
  templateUrl: './stage-ing.component.html'
})
export class StageIngComponent implements OnInit {
  stages: StageIng[] = [];
  selectedFiles: Record<string, File | null> = {
    lettre: null,
    journal: null,
    rapport: null
  };
  newNote: number = 0;

  constructor(private stageService: StageIngService) {}

  ngOnInit(): void {
    this.loadStages();
  }

  onFileSelected(event: Event, type: string): void {
    const file = (event.target as HTMLInputElement).files?.[0];
    if (file) {
      this.selectedFiles[type] = file;
    }
  }

  submitStage(event: Event): void {
    event.preventDefault(); // empêche rechargement

    if (!this.selectedFiles['lettre'] || !this.selectedFiles['journal'] || !this.selectedFiles['rapport']) {
      alert("Tous les fichiers sont requis.");
      return;
    }

    const formData = new FormData();
    formData.append('lettreAffectation', this.selectedFiles['lettre']!);
    formData.append('journalStage', this.selectedFiles['journal']!);
    formData.append('rapportStage', this.selectedFiles['rapport']!);

    this.stageService.submitStage(formData).subscribe({
      next: () => {
        alert("Stage soumis avec succès !");
        this.loadStages();
      },
      error: err => {
        console.error("Erreur lors de la soumission :", err);
        alert("Erreur : échec de la soumission.");
      }
    });
  }

  loadStages(): void {
    this.stageService.getAllStages().subscribe(data => {
      this.stages = data;
    });
  }

  updateNote(id: number): void {
    this.stageService.updateNote(id, this.newNote).subscribe(() => {
      this.loadStages();
    });
  }

  deleteStage(id: number): void {
    this.stageService.deleteStage(id).subscribe(() => {
      this.loadStages();
    });
  }

  download(id: number, type: string): void {
    this.stageService.downloadFile(id, type).subscribe(blob => {
      const url = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = url;
      link.download = `${type}.pdf`;
      link.click();
      window.URL.revokeObjectURL(url);
    });
  }
}
