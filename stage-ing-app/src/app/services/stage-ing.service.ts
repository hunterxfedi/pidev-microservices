import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface StageIng {
  id: number;
  valide: boolean;
  note: number;
}

@Injectable({
  providedIn: 'root'
})
export class StageIngService {
  private baseUrl = 'http://localhost:8089/stage-ing'; // via Gateway

  constructor(private http: HttpClient) {}

  getAllStages(): Observable<StageIng[]> {
    return this.http.get<StageIng[]>(`${this.baseUrl}/all`);
  }

  submitStage(formData: FormData): Observable<any> {
    return this.http.post(`${this.baseUrl}/submit`, formData);
  }

  downloadFile(id: number, type: string): Observable<Blob> {
    const params = new HttpParams().set('type', type);
    return this.http.get(`${this.baseUrl}/${id}/download`, {
      params,
      responseType: 'blob'
    });
  }

  updateNote(id: number, note: number): Observable<StageIng> {
    const params = new HttpParams().set('note', note.toString());
    return this.http.put<StageIng>(`${this.baseUrl}/${id}/grade`, null, { params });
  }

  deleteStage(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${id}`);
  }
}
