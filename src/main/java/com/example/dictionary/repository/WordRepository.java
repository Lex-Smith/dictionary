package com.example.dictionary.repository;

import com.example.dictionary.entity.Word;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class WordRepository {
    private final Map<String, Word> dictionary = new HashMap<>();

    public void add(Word word) {
        try {
            delay();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        dictionary.put(word.getWord(), word);
    }

    public List<Word> findAll() {
        try {
            delay();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>(dictionary.values());
    }

    private void delay() throws InterruptedException {
        Thread.sleep(3000);
    }
}
