package com.company.parser;

import com.company.stat.Statistics;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Parser {

    private static final char[] separators = {' ', ',', '.', '!', '?','"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};

    private static boolean isSeparator(char c) {
        for(int i = 0; i < separators.length; i++) {
            if(separators[i]==c)
                return true;
        }
        return false;
    }

    public static Statistics parseFile(String fileName) throws IOException {
        Statistics stat = new Statistics(fileName);
        BufferedReader reader = new BufferedReader( new FileReader (fileName));
        String line;
        int wordStart; //начало слова
        while ((line = reader.readLine()) != null) {
            wordStart=0;
            for(int i = 0; i < line.length(); i++) {
                if(isSeparator(line.charAt(i))) {
                    if(wordStart!=i) {
                        stat.addWord(line.substring(wordStart,i)); //добавление слова в статистику
                    }
                    wordStart=i+1;
                }
            }
        }
        return stat;
    }
}
