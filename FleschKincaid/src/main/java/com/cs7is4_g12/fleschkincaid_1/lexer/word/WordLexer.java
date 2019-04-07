package com.cs7is4_g12.fleschkincaid_1.lexer.word;

import java.util.ArrayList;
import java.util.List;

import com.cs7is4_g12.fleschkincaid_1.lexer.sentence.Sentence;
 
public class WordLexer {

    public List<Word> tokenize(final Sentence sentence) {
        final List<Word> words = new ArrayList<>();

        final String[] parsedWords = sentence.getText().split("\\s+");
        for (final String word : parsedWords) {
            words.add(new Word(word));
        }

        return words;
    }

}
