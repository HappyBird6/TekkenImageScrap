package com.example;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class test {
    public void process(String style,String name){
        style = 
        "background: linear-gradient(0deg, rgb(0, 0, 0) 0%, rgb(0, 0, 0) 10%, rgba(0, 0, 0, 0) 54.62%), url(&quot;https://media.graphassets.com/n1vLUNXRtGCcmIEOwRaj&quot;) center center / cover no-repeat;";
        name = "Alisa";
        
        String url = style.split(" ")[15];
        //url = url(&quot;https://~~~.com/~~~&quot;)
        url = url.split("&quot;")[1];

        download(url,name);
    }
    public void download(String imageUrl,String name){
        try {
            String fileName = name+".webp";
            // HTTP 요청을 통해 이미지 다운로드
            URL url = new URL(imageUrl);
            try (BufferedInputStream in = new BufferedInputStream(url.openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream("./images/"+fileName)) {

                byte dataBuffer[] = new byte[1024];
                int bytesRead;

                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }

                System.out.println("이미지 다운로드 완료: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}