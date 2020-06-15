import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobPosting } from './job-posting';
import { JobPostingSearchResponse } from './job-posting-search-response';

@Injectable({
  providedIn: 'root'
})
export class JobPostingService {

  constructor(private http: HttpClient) { }

  private getHeaders(){
    const headers = new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Api-Key', 'xxx');
    
    return {
      headers : headers
    };
  }
  
  findById(globalId: string) : Observable<JobPosting> {
    return this.http.get<JobPosting>("/jobs/" + globalId, this.getHeaders() );
  }

  search() : Observable<JobPostingSearchResponse>{
    return this.http.get<JobPostingSearchResponse>("/jobs/", this.getHeaders() );
  }
  
}
