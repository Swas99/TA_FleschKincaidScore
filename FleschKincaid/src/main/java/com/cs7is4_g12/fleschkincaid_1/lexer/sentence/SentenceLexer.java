package com.cs7is4_g12.fleschkincaid_1.lexer.sentence;

import java.util.List;


public interface SentenceLexer {

    List<Sentence> tokenize(String text);
}
