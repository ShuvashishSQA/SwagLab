package com.swaglab.pom;

//ExtendReport dependencies
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


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
import java.time.Duration;
import java.util.Properties;

public abstract class baseSwagTest {
    protected static ExtentReports extent;
    protected static ExtentTest test;

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

        driver.get(getBaseURL());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public void takeScreenshot(String testName) {

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Define the path for the screenshot folder
            File destination = new File("Screenshots/" + testName + ".png");

            // Copy the screenshot to the destination path
            FileUtils.copyFile(screenshot, destination);

            if (!destination.exists()) {
                destination.mkdirs();  // Create the directory if it does not exist
            }
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


    public void captureScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS) {
            takeScreenshot(result.getName());
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        captureScreenshot(result);
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        if(driver != null)
            driver.quit();
    }

}
