# Cordview - The interview coordiation tool
- date created: June 1, 2020

## Requirements

### Creating job postings

As a JOB_POSTER I want to 

1. CRUD a job posting with the following data (job: {title, description, wage($/HR vs $/Per year)}, date posted) 
2. Access JOB_POSTER view

### Applying to job postings

As a JOB_SUBMITTER I want to 

1. Submit an applicant to a job posting
* Required (date created, submitter:{name, company, email, phone}, candidate:{name, resume}, skillToYearsOfExperience, jobPosting )
2. Find job postings
3. Access JOB_SUBMITTER view
4. review applications I submitted
5. want someone to review my application submittions

### Reviewing applicants

As a APP_SUBMIT_REVIEWER I want to 

1. access a page to view applications submitted for a job posting
2. subscribe my email to a job posting application submissions
3. reject an applicant and have an email sent to them
4. approve the applicant for an interview
5. Required: add note about accept_app /reject_app setup interview decision
6. see the state of a application submissions for a job posting
7. export the state of all application submissions as a CSV doc
8. submit notes for the phone interview interview and change state to passed_phone / failed_phone
8. submit notes for the face to face interview and change state to passed_final / failed_final

### Scheduling interviews 

As a INTERVIEW_SCHEDULER I want to 

1. subscribe to job posting interviewing setup state changes
2. CRUD schedule an interview with a manager & interviewer at a time
* contains: (interview:{startTime, endTime}, notes)
3. have email sent out to manager, interviewer and me when an interview is scheduled
* email: interviewer.email.contains(interview:{startTime, endTime}, notes)
