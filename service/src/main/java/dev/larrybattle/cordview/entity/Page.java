package dev.larrybattle.cordview.entity;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private List<T> content;
    private int total;
    private int count;
}
