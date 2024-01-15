package com.example.sqlite_test;

import java.io.IOException;

public class RunBat {
    public static void run(String path) {

        try {
            Process p = Runtime.getRuntime().exec(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}