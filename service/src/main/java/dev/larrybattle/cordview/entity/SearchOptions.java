package dev.larrybattle.cordview.entity;

import lombok.Getter;
import lombok.Setter;

// TODO Replace with Spring Options
public class SearchOptions {

    @Getter
    @Setter
    private int limit;

    @Getter
    @Setter
    private int offset;

    public SearchOptions(int limit, int offset){
        this.limit = limit;
        this.offset = offset;
    }
}

