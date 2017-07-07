package com.doit.task2;

import java.io.*;

public class ParseFile {

    private String fileName;


    public ParseFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String read() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        File file = new File(fileName);

        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                boolean isMultilineComment = false;

                while ((s = in.readLine()) != null) {

                    int start = s.indexOf("/*");
                    int end = s.indexOf("*/");
                    if (!isMultilineComment || end >= 0) {
                        String newStr = s;
                        if (start >= 0) {
                            isMultilineComment = true;
                            newStr = s.substring(0, start);
                        }
                        if (end >= 0) {
                            isMultilineComment = false;
                            if (start >= 0) {
                                newStr = newStr + s.substring(end + "*/".length());
                            } else {
                                newStr = s.substring(end + "*/".length());

                            }
                        }
                        sb.append(newStr);
                        if (!isMultilineComment) {
                            sb.append("\n");
                        }
                    }
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    public void print() {
        try {
            System.out.println(read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
