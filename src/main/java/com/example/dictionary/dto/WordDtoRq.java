package com.example.dictionary.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WordDtoRq {
    private String word;
    private String description;
}
