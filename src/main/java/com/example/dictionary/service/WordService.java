package com.example.dictionary.service;

import com.example.dictionary.dto.WordDtoRq;
import com.example.dictionary.dto.WordDtoRs;
import com.example.dictionary.entity.Word;
import com.example.dictionary.repository.WordRepository;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public WordDtoRs add(WordDtoRq dto) {
        Word word = new Word(dto.getWord(), dto.getDescription());
        wordRepository.add(word);
        return convertToWordDtoRs(word);
    }

    public List<WordDtoRs> getWords(Integer startElement, Integer portionSize) {
        return wordRepository.findAll().stream()
                .sorted(new WordComparator())
                .skip(startElement)
                .limit(portionSize)
                .map(this::convertToWordDtoRs)
                .toList();
    }

    private WordDtoRs convertToWordDtoRs(Word word) {
        return new WordDtoRs(word.getWord(), word.getDescription());
    }

    static class WordComparator implements Comparator<Word> {

        public int compare(Word a, Word b) {
            return a.getWord().toUpperCase().compareTo(b.getWord().toUpperCase());
        }
    }
}
