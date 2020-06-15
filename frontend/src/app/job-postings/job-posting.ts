import { JobPostingState } from "./job-posting-state.enum";
import { JobPostingWageType } from "./job-posting-wage-type.enum";

export interface JobPosting {
    globalId: string;
    dateCreated: string;
    lastUpdated: string;
    title : string;
    description: string;
    wageAmount: string;
    isActive: boolean;
    internalNotes: string;
    state : JobPostingState;
    wageType: JobPostingWageType;
}
