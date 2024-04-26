package com.example.dictionary.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Word {
    @NonNull
    private String word;
    @NonNull
    private String description;
}
