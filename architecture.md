# Cordview - The interview coordiation tool
- date created: June 1, 2020

## Requirements

## Architecture

### DTO

class JobPostingDTO{}
class UserDto{}
class JobApplicantDto{}
class NoteEntryDto{};
class InterviewDto{}


### Mapper

JobPostingDTO to JobPosting

### Service

// BasicRepository could be Spring Data JPA JpaRepository.class
interface BasicRepository<T> implements JpaRepositoryImpl {
    T create(T item);
    T save(T item);
    boolean delete(String globalId);
    T findById(String globalId);
    Page<T> search(SearchOptions options);
}

// The Dto services perform the logic for the controllers
class JobPostingService {
    JobPostingDto get(String globalId);
    JobPostingDto create(JobPostingDto jobPosting);
    JobPostingDto update(String globalId, JobPostingDto jobPosting);
    boolean disable(String globalId);
    Page<JobPostingDto> search(SearchOptions options);
}

class JobPostingRepositoryService implements BasicRepository<JobPosting>{};

class JobApplicantService {
    JobApplicantDto applyToJob(String jobPostingGlobalId, JobApplicantDto jobApp);
    JobApplicantDto update(JobPosting jobPosting);
    boolean delete(String globalId);
    Page<JobPosting> search(SearchOptions options);

    Page<JobApplicant> findAllJobApplicantsByUser(String userGlobalId);    
}

class JobApplicantRepositoryService implements BasicRepository<JobPosting> {
    JobApplicant create(String jobPostingGlobalId, JobApplicant jobApp);
    Page<JobApplicant> findAllJobApplicantsByUser(String userGlobalId);
    
};

class JobApplicantManagementService {
    boolean processStateChange(JobApplicant jobApplicant, JobApplicantState oldState, JobApplicantState newState, User changedBy);
    void onApplicantSubmissionEvent(JobApplicant jobApplicant);
    void onApplicantRejection(JobApplicant jobApplicant);
    void onPhoneScreen(JobApplicant jobApplicant);
    void onInPersonMeeting(JobApplicant jobApplicant);
}

class UserService {
    UserDto get(String globalId);
    UserDto create(UserDto user);
    UserDto update(String globalId, UserDto user);
    boolean disable(String globalId);
    Page<JobPostingDto> search(SearchOptions options);
    UserDto findByEmail(String email);
}

class UserRepositoryService implements BasicRepository<User>{
    User findByEmail(String email);
};


interface EmailService {
    sendEmail(String[] to, String[] from, String content);
}

class AmazonSESEmailService implements EmailService; 

class CsvService {
    String export(String fileName, String[] headers, String[] rows);
    String export(List<JobPosting> jobPostings );
    String export(List<JobApplicant> jobApplicants );
}

class UserLoginService {

    UserDto loginByEmail(String email);
    boolean hasUserWithEmail(String email);

}

### Class

class Page {
    List<> content;
    integer total;
    integer count;  
}

class SearchOptions {
    int limit;
    int offset;
}

### Entity


enum JobAppRole {
    POSTER,
    SUBMITTER,
    APPLICANT,
    APPLICANT_REVIEWER,
    SCHEDULER;
}
enum WageType{
    HOURLY,
    ANNUALLY;
}
enum JobPostingState{
    DRAFT,
    OPEN,
    HALT,
    FILLED;
}
enum JobApplicantState {
    SUBMITTED,
    REJECTED,
    PHONE_SCREEN,
    IN_PERSON_MEETING,
    OFFER_TALK,
    OFFER_ACCEPTED,
    OFFER_REJECTED,
    HIRED;
}

class User {
    Long id;
    String globalId;
    boolean isActive;
    boolean isInternal;
    String firstName;
    String lastName;
    String company;
    String phone;
    String email;
    JobAppRole role;
    List<String> companyNotes;
}

class JobPosting {
    String id;
    String globalId;
    boolean isActive;
    JobPostingState state;
    String title;
    String description;
    String wageAmount;
    WageType wageType;
    Date dateCreated;
    Date lastUpdated;
    String innerNote;
    User createdBy;
    User owner;
    Set<User> subscribers;
    Set<JobApplicant> jobApplicants;
}

class JobApplicant {
    Long id;
    String globalId;
    JobApplicantState state;
    List<NoteEntry> notes;
    Date dateCreated;
    Date lastUpdated;
    JobPosting jobPosting;
    String experience;
    String resume;
    User submitter;
    User candidate;
    Interview phoneScreen;
    Interview inPerson;
}

class NoteEntry {
    Long id;
    String globalId;
    Date dateCreatd;
    User createdBy;
    String note;
}

class Interview {
    Long id;
    String globalId;
    Date startDateTime;
    Date endDateTime;
    String timezone;
    String emailContent;
    Set<User> interviewer;
    Date createdBy;
}

### Routes

- NOTE: activeUser is passed to template for role checking and updating related DTO.

- HomeController
- route: /
- methods: GET
<app-home activeUser=${user}/>
<app-server-error-page/>
<app-404-error-page/>
<app-login/>
<app-account-create-form/>
<app-logout activeUser=${user}/>

- JobsController
- route: /jobs
* methods: GET|POST
<app-job-postings jobs=${jobPostings} activeUser=${user}/>
<app-job-posting-create-form activeUser=${user}/>

- JobController
- route: /jobs/${job-posting-global-id} 
* methods: GET|PUT|DELETE 

<app-job-posting job=${jobPosting}/>
<app-job-posting-subscribe job=${jobPosting} activeUser=${user}/>
<app-job-posting-update-form job=${jobPosting} activeUser=${user}/>
<app-job-posting-application-create-form job=${jobPosting} activeUser=${user}/>

- JobApplicantsController
- route: /jobs/${job-posting-global-id}/job-applicants(?.csv)
* methods: GET|POST
<app-job-applicants job="jobPosting" applicants=${applicants}  activeUser=${user}/> 

- JobApplicantController
- route: /jobs/${job-posting-global-id}/job-applicants/${job-applicant-global-id}
* methods: GET|PUT
<app-job-applicant applicant=${applicant} activeUser=${user}/> 
<app-job-applicant-progress-update-form applicant=${applicant} activeUser=${user}/>
<app-job-applicant-interview interview=${interview} activeUser=${user}/>
<app-job-applicant-note note=${noteEntry} activeUser=${user}/>

- UsersController
- route: /users/
* methods: GET
<app-users users=${users} activeUser=${user}/>

- UserController
- route: /users/${user-global-id}/
* methods: GET|PUT
<app-user user=${user} activeUser=${user}/>
<app-user-update-form user=${user}  activeUser=${user}/>



### External Services

- Database: H2
- Email Serivce: Amazon SeS
- Messaging: RabbitMQ

### Tech

- Frontend: Angular 9
- Backend: SpringBoot
- Docker: ubuntu slim 18

### TODO

- Add users service, view
* // 4. review applicants I submitted
- TODO update JobApplicants vs JobApplication working where needed