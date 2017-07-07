package com.doit;

import com.doit.task1.MimeTypeChecker;
import com.doit.task2.ParseFile;

public class Main {

    public static void main(String[] args) {

        String fileName = "/Users/mac/test.txt";

        ParseFile parseFile = new ParseFile(fileName);
        parseFile.print();

        MimeTypeChecker mimeTypeChecker = new MimeTypeChecker();
        mimeTypeChecker.printResult();
    }
}
