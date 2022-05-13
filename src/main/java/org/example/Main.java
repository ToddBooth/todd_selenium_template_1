package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    // Chrome
    static final String DRIVER_TYPE = "webdriver.chrome.driver";
    static final String DRIVER_FILE = "./drivers/chromedriver_v101.exe";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Selenium World.");

        String xpath;
        String css;

        // Chrome
        System.setProperty(DRIVER_TYPE, DRIVER_FILE);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);

        // Yahoo
        driver.get("https://yahoo.com");
        System.out.println(driver.getTitle());
        driver.manage().deleteAllCookies();
        // This may result in a different web page, since cookies are now deleted.
        driver.get("https://yahoo.com");

        Thread.sleep(200);
        xpath = "/html//div[@id='consent-page']/div/div//form//button[@name='agree']";
        driver.findElement(By.xpath(xpath)).click();

        Thread.sleep(200);
        // xpath = "//div[@innertext='Logga in']";
        // driver.findElement(By.xpath(xpath)).click();
        css = "._yb_trcuk";
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
        // I disabled the following so that I don't actually create a Yahoo account
        // xpath = "//html[@id='Stencil']//button[@id='reg-submit-button']";
        // driver.findElement(By.xpath(xpath)).click();

        // Clean up manually
        driver.manage().deleteAllCookies();
        driver.close();
    }
}