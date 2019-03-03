package com.cs7is4_g12.fleschkincaid_1.lexer.sentence;


public class Sentence {

    public final String text;

    public Sentence(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "text='" + text + '\'' +
                '}';
    }

}
