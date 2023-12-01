package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class App {
    private WebDriver driver;
    private String url;
    // 크롬 버전 : 
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Park/JAVA/Selenium_EX/TekkenImageScrapper/chromedriver-win64/chromedriver.exe";
        
    public App(){
        // WebDriver 경로 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        // WebDriver 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blokcing");
        
        driver = new ChromeDriver(options);

        url = "https://tekken.com/fighters";
    }
    public void scrap(){
        List<WebElement> elements_image = null;
        List<WebElement> elements_name = null;
        try{
            driver.get(url);
            Thread.sleep(3000); // 페이지 로딩 대기시간
            
            elements_image = driver.findElements(By.className("thumbnail__image"));
            elements_name = driver.findElements(By.className("thumbnail__title"));
            for(int i = 0;i<elements_image.size();i++){
                WebElement w1 = elements_image.get(i);
                WebElement w2 = elements_name.get(i);
                String style = w1.getAttribute("style");
                style.indexOf("url");
                String name = w2.getText();
                new test().process(style, name);
            }      
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            driver.close();
        }
    }
    public static void main(String[] args) throws Exception {
        //new App().scrap();
        new test().process("123", "123");
    }
}
