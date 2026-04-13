package com.resumescreening.resume_screener.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextProcessor {

    // Cleans text by removing punctuation, lowercasing, and splitting into words
    public static List<String> cleanAndTokenize(String text) {
        if (text == null || text.isEmpty()) {
            return List.of();
        }

        // Replace everything that isn't a letter or number with a space
        String cleanText = text.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // Split by spaces and remove empty blanks
        return Arrays.stream(cleanText.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toList());
    }
}

