package com.automation.driver;

import com.automation.utils.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final List<Dimension> resolutions = new ArrayList<>();

    static {
        String[] resolutionList = ConfigManager.getResolutions();
        for (String res : resolutionList) {
            String[] dimensions = res.split("x");
            resolutions.add(new Dimension(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1])));
        }
    }

    /**
     * GetDriver
     * @return Own webdriver for every Thread
     */
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            int index = (int) (Thread.currentThread().getId() % resolutions.size());
            System.out.println("index " + index);
            driver.manage().window().setSize(resolutions.get(index));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }


    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
