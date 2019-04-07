package com.cs7is4_g12.fleschkincaid_1.lexer;

import com.cs7is4_g12.fleschkincaid_1.lexer.syllable.SyllableLexer;
import com.cs7is4_g12.fleschkincaid_1.lexer.word.Word;

import org.junit.Test;

public class SyllableLexerTest {

    @Test
    public void countTest() {
        count("kawazaki");
        count("am");
        count("going");
        count("away");
        count("syllable");
        count("arrangement");
        count("strange");
    }

    private void count(final String word) {
        System.out.println("counting syllables: " + word);
        final SyllableLexer syllableLexer = new SyllableLexer();
        System.out.println(syllableLexer.count(new Word(word)));
    }

}
