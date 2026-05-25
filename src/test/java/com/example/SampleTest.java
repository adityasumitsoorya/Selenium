package com.example;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {
    private static final String True = null;
	WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // CRITICAL FOR CI/CD PIPELINES:
        options.addArguments("--headless=False"); 
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized"); 

        driver = new ChromeDriver(options);
    }

    @Test
    public void verifyTitle() {
    	driver.get("https://www.google.com");
    	System.out.println(driver.getTitle());
    	
   

        // 3. Optional: Maximize the window
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 4. Close the browser after a few seconds
        // driver.quit(); 
           String title = driver.getTitle();
           Assert.assertTrue(title.contains("Google"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}