package com.example.sqlite_test;

public class Main {
    public static void main(String[] args) {

        String batPath = "./db_to_txt.bat";
        RunBat.run(batPath);



        
        String txtPath = "./database.txt";
        StringBuilder sb = ReadFile.getSql(txtPath);

    }
}
