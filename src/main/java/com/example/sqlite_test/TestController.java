package com.example.sqlite_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @PostMapping(value = { "/register/action" }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String registerAction(@RequestParam("file") MultipartFile mf) {
        if (mf != null) {
            String oriName = mf.getOriginalFilename();
            String type = mf.getContentType();
            log.info("\n파일 이름 : " + mf.getOriginalFilename());
            log.info("\n파일 타입 : " + mf.getContentType());
            log.info("\n파일 파라미터 이름 : " + mf.getName());
            log.info("\n파일 사이즈 : " + mf.getSize());

            File file = new File("./saveFiles/" + oriName);

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

        } else {
            log.info("\nmf is null!!");
        }
        return "/views/form";
    }

}
