import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { JobPostingService } from './job-postings/job-posting.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private jobPostingService : JobPostingService){

  }

  async ngOnInit(){
    console.log("Searching for jobs");
    this.jobPostingService.search().subscribe(jobs => {
      console.log("Server results: " + jobs);
    });
  }
}
