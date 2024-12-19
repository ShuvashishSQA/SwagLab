package com.swaglab.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public abstract class baseSwagTest {
    final Properties properties;

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

    public void takeScreenshot(String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Users\\Mir IT\\IdeaProjects\\SwagLab\\Screenshots" + testName + ".png");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getBaseURL() {
        return properties.getProperty("baseURL");
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


    public void captureScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS) {
            takeScreenshot(result.getName());
        }
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        captureScreenshotOnFailure(result);
        Thread.sleep(3000);
        //driver.quit();
    }

    @AfterTest
    public void closeBrowser(ITestResult result) throws InterruptedException {
        driver.quit();
    }

}
