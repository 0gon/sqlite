package com.example.sqlite_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
    public static StringBuilder getSql(String path) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        try {
            // 파일경로 지정할 수 있게 변경하기
            FileInputStream input = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(input, "UTF-8");
            br = new BufferedReader(reader);

            int ch;

            while ((ch = br.read()) != -1) {
                sb.append((char) ch);
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] arr = sb.toString().split(";");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "번째 쿼리문 : " + arr[i] + "\n");
        }

        return sb;
    }
}
