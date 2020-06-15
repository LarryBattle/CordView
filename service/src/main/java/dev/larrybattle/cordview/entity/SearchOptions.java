package dev.larrybattle.cordview.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// TODO Replace with Spring Options
@Data
public class SearchOptions {
    private int limit;
    private int offset;

    public SearchOptions(int limit, int offset){
        this.limit = limit;
        this.offset = offset;
    }
}

