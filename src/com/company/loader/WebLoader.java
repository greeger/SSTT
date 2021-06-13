package com.company.loader;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.net.URL;
import java.net.MalformedURLException;

public class WebLoader {

    //метод для скачивания страницы в файл
    public static void DownloadWebPage(String webpage, String fileName) throws MalformedURLException, IOException {
        URL url = new URL(webpage);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line+"\n");
        }
        reader.close();
        writer.close();
    }
}
