package com.company.stat;

import java.util.HashMap;

public class Statistics {

    private String fileName; //имя файла

    private HashMap<String,Integer> stat; //статистика уникальных слов

    public Statistics() {
        fileName = null;
        stat = new HashMap<>();
    }

    public Statistics(String fileName) {
        this.fileName = fileName;
        stat = new HashMap<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public HashMap<String, Integer> getStat() {
        return stat;
    }

    public void addWord(String word) {
        if(stat.containsKey(word))
            stat.replace(word,stat.get(word)+1);
        else
            stat.put(word,1);
    }
}
