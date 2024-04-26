package com.example.dictionary.controller;

import com.example.dictionary.dto.WordDtoRq;
import com.example.dictionary.dto.WordDtoRs;
import com.example.dictionary.service.WordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/word")
@CacheConfig(cacheNames = "findAll, add")
public class WordController {
    private final WordService wordService;

    @PostMapping
    @Cacheable(cacheNames = "add")
    @CacheEvict(cacheNames = "findAll", allEntries = true)
    public ResponseEntity<WordDtoRs> createWord(@RequestBody WordDtoRq dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wordService.add(dto));
    }

    @GetMapping("/portion")
    @Cacheable(cacheNames = "findAll")
    public List<WordDtoRs> getAllWords(@RequestParam Integer startElement,
                                       @RequestParam Integer pageSize) {
        return wordService.getWords(startElement, pageSize);
    }
}
