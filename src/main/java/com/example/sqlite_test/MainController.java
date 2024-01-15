package com.example.sqlite_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.annotation.Resource;

@Controller
public class MainController {

    @GetMapping("/upload")
    public String upload() {
        System.out.println("hihi");
        return "/views/upload";
    }

    @PostMapping("/register/action")
    public void registerAction(MultipartFile mf) {
        String oriName = mf.getOriginalFilename();
        String type = mf.getContentType();

        File file = new File("./" + oriName);

        FileOutputStream fos = null;

        try {
            byte[] bytes = mf.getBytes();
            fos = new FileOutputStream(file);
            fos.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
