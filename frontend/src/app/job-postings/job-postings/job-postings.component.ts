import { Component, OnInit } from '@angular/core';
import { JobPostingService } from '../job-posting.service';
import { JobPosting } from '../job-posting';

@Component({
  selector: 'app-job-postings',
  templateUrl: './job-postings.component.html',
  styleUrls: ['./job-postings.component.css']
})
export class JobPostingsComponent implements OnInit {

  jobs : JobPosting[]

  constructor(private jobPostingService : JobPostingService){

  }

  ngOnInit() : void {
    console.log("Searching for jobs");
    this.jobs = [
      {
        globalId: "globalId",
        dateCreated: new Date().toISOString(),
        lastUpdated: new Date().toISOString(),
        title : "Full Stack Dev",
        description: "Know java?",
        location: "Dallas, TX",
        wageAmount: "30.00",
        isActive: true
      },
      {
        globalId: "globalId",
        dateCreated: new Date().toISOString(),
        lastUpdated: new Date().toISOString(),
        title : "Marketing Intern",
        description: "Know marketing?",
        location: "Dallas, TX",
        wageAmount: "30.00",
        isActive: true
      }
    ]
    this.jobPostingService.search().subscribe(jobs => {
      console.log("Server results: " + jobs);
    });
  }

}
