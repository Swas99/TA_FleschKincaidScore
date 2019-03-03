package com.cs7is4_g12.fleschkincaid_1.lexer.word;
 
public class Word {

    private final String text;

    public Word(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Word{" +
                "text='" + text + '\'' +
                '}';
    }

}

