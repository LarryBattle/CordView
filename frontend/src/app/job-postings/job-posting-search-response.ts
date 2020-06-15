import { JobPosting } from "./job-posting";

export interface JobPostingSearchResponse {
  content : JobPosting[];
  total: number;
  count: number;
}
