package com.company;

import com.company.loader.WebLoader;
import com.company.parser.Parser;
import com.company.stat.Statistics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //раскомментировать, если надо вводить адрес запроса из консоли
        //Scanner scnnr = new Scanner(System.in);
        //System.out.println("Enter URL:");
        //String answer = scnnr.nextLine();

        String fileName = "Download.html";
        try {
            WebLoader.DownloadWebPage(args[0]/*answer*/,fileName);
            Statistics stat = Parser.parseFile(fileName);
            for(HashMap.Entry<String, Integer> item : stat.getStat().entrySet()){
                System.out.println(item.getKey()+" - "+item.getValue());
            }
        }
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        } catch (IOException ie) {
            System.out.println("IOException raised");
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("ArrayIndexOutOfBoundsException raised");
        }
    }
}
