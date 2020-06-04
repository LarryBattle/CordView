package dev.larrybattle.cordview.entity;

// TODO Replace with Spring Options
public class SearchOptions {
    int limit;
    int offset;
    SearchOptions(int limit, int offset){
        this.limit = limit;
        this.offset = offset;
    }
}

