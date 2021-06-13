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
        int ws; //начало слова
        while ((line = reader.readLine()) != null) {
            ws=0;
            for(int i = 0; i < line.length(); i++) {
                if(isSeparator(line.charAt(i))) {
                    if(ws!=i) {
                        stat.addWord(line.substring(ws,i)); //добавление слова в статистику
                    }
                    ws=i+1;
                }
            }
        }
        return stat;
    }
}
