package com.cs7is4_g12.fleschkincaid_1.lexer.syllable;

import com.cs7is4_g12.fleschkincaid_1.lexer.word.Word;

/**
 * implementation from: http://shiffman.net/teaching/a2z/week1/
 * TODO use actual syllable dictionary
 */
public class SyllableLexer {

    public int count(final Word word) {
        final String wordText = word.getText();
        int count = 0;
        boolean vowel = false;

        if (wordText.isEmpty()) { return 0; }

        // check each word for vowels (don't count more than one vowel in a row)
        for (int i = 0; i < wordText.length(); i++) {
            if (isVowel(wordText.charAt(i)) && !vowel) {
                vowel = true;
                count++;
            } else if (isVowel(wordText.charAt(i)) && vowel) {
                vowel = true;
            } else {
                vowel = false;
            }
        }

        // check for 'e' at the end, as long as not a word w/ one syllable
        final char lastChar = wordText.charAt(wordText.length() - 1);
        if ((lastChar == 'e' || lastChar == 'E') && count != 1) {
            count--;
        }
        return count;
    }

    public boolean isVowel(final char c) {
        return c == 'a' || c == 'A'
            || c == 'e' || c == 'E'
            || c == 'i' || c == 'I'
            || c == 'o' || c == 'O'
            || c == 'u' || c == 'U'
            || c == 'y' || c == 'Y';
    }

}
