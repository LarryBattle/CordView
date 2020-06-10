package dev.larrybattle.cordview.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Page<T> {

    @Getter
    @Setter
    private List<T> content;

    @Getter
    @Setter
    private int total;

    @Getter
    @Setter
    private int count;
}
