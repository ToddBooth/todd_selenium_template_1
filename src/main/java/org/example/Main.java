package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    // Chrome
    static String DRIVER_TYPE = "webdriver.chrome.driver";
    static String DRIVER_FILE = "./drivers/chromedriver_v101.exe";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Selenium World.");

        // Chrome
        System.setProperty(DRIVER_TYPE, DRIVER_FILE);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);

        // Maximizes window to show the full content (the "Try for free" button)
        driver.manage().window().maximize();

        // Yahoo
        driver.get("https://yahoo.com");
        System.out.println(driver.getTitle());
        driver.manage().deleteAllCookies();

        Thread.sleep(200);
        String xpath = "/html//div[@id='consent-page']/div/div//form//button[@name='agree']";
        driver.findElement(By.xpath(xpath)).click();

        Thread.sleep(200);
        xpath = "//div[@innertext='Logga in']";
        // driver.findElement(By.xpath(xpath)).click();
        String css = "._yb_trcuk";
        driver.findElement(By.cssSelector(css)).click();

        Thread.sleep(200);
        xpath = "//html[@id='Stencil']//a[@id='createacc']";
        driver.findElement(By.xpath(xpath)).click();

        Thread.sleep(200);
        xpath = "//html[@id='Stencil']//input[@id='usernamereg-firstName']";
        driver.findElement(By.xpath(xpath)).sendKeys("John");

        Thread.sleep(200);
        xpath = "//html[@id='Stencil']//input[@id='usernamereg-lastName']";
        driver.findElement(By.xpath(xpath)).sendKeys("Doe" +
                Keys.TAB + "hejsan2477" +
                Keys.TAB + "password123" +
                Keys.TAB + "1998");

        Thread.sleep(200);
        xpath = "//html[@id='Stencil']//button[@id='reg-submit-button']";
        // I disabled the following so that I don't actually create a Yahoo account
        // driver.findElement(By.xpath(xpath)).click();

        // Clean up manually
        driver.manage().deleteAllCookies();
        driver.close();
    }
}