package com.swaglab.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class baseSwagTest {
    private Properties properties;

    public static WebDriver driver;

    public baseSwagTest() {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\configurations";
        properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeTest
    public void getBrowserSetup() {
        String browserName = getBrowser();
        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        /*System.out.println(getPassword());
        System.out.println(getBaseURL());
        System.out.println(getBrowser());
        System.out.println(driver);*/

        driver.get(getBaseURL());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }


    public String getBaseURL() {
        return properties.getProperty("baseURL");
    }
    public String getUserName() {
        return properties.getProperty("userName");
    }
    public String getPassword() {
        return properties.getProperty("password");
    }
    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getCheckoutFirstUserName() {
        return properties.getProperty("checkoutFirstName");
    }
    public String getCheckoutLastUserName() {
        return properties.getProperty("checkoutLastName");
    }
    public String getCheckoutZipCode() {
        return properties.getProperty("checkoutZipCode");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
