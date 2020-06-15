package dev.larrybattle.cordview.service;

import dev.larrybattle.cordview.entity.SearchOptions;

public class JobPostingSearchOptions extends SearchOptions {
    public JobPostingSearchOptions(int limit, int offset) {
        super(limit, offset);
    }

    public JobPostingSearchOptions(int limit) {
        this(limit, 0);
    }
}
