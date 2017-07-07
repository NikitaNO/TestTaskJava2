package com.doit.task1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MimeTypeChecker {
    private Map<String, String> types;

    public MimeTypeChecker() {
        types = new HashMap();
        types.put("txt", "text/plain");
        types.put("png", "image/png");
        types.put("html", "text/html");
    }

    public void addMimeType(String ext, String type) {
        if (types != null) {
            types.put(ext.toLowerCase(), type);
        }
    }

    public void printResult() {

        List<String> filesList = new LinkedList<>();
        filesList.add("/Users/mac/depl.txt");
        filesList.add("/Users/mac/Downloads/Снимок.PNG");
        filesList.add("/Users/mac/Downloads/pages-2017/page.html");
        filesList.add("/Users/mac/text");


        for (String path : filesList) {
            int index = path.lastIndexOf(".");
            System.out.println(types.get(path.substring(index + 1).toLowerCase()));
        }

    }
}
