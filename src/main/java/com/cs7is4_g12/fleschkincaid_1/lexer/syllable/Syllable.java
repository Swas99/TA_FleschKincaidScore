package com.cs7is4_g12.fleschkincaid_1.lexer.syllable;
 
public class Syllable {

    private final String text;

    public Syllable(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Syllable{" +
                "text='" + text + '\'' +
                '}';
    }

}

