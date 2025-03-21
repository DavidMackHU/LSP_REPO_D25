package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * returns all long words.
 * needs to handel multiple spaces and ensures words are returned in order of appearance.
 * 
 * @author David Mack
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor initializes the WordProcessor with a given sentence.
     * 
     * @param sentence The input sentence to process.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence.
     * 
     * @return A list of longest words in the sentence.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // Return empty list for empty or whitespace-only input
        }

        String[] words = sentence.split("\\s+"); // Splitting handles multiple spaces
        int maxLength = 0;

        // Determine the maximum word length
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        // Collect words with the maximum length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}

