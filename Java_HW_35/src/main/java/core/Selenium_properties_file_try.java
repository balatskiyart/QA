package core;

/**
 * Created by Artem on 3/14/16.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_properties_file_try {

    public static void main(String[] args) {

        String text_case_id = null;
        String url = null;
        String title_expected = null;

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("./src/main/resources/Test.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        text_case_id = properties.getProperty("text_case_id");
        url = properties.getProperty("url");
        title_expected = properties.getProperty("title_expected");

        WebDriver driver = new FirefoxDriver();

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String title_actual = driver.getTitle();

        if (title_expected.equals(title_actual)) {
            System.out.println("Test Case ID: \t\t" + text_case_id);
            System.out.println("URL: \t\t\t" + url);
            System.out.println("Title Expected: \t" + title_expected);
            System.out.println("Title Actual: \t\t" + title_actual);
            System.out.println("Test Case Result: \t" + "PASSED");
        } else {
            System.out.println("Test Case ID: \t\t" + text_case_id);
            System.out.println("URL: \t\t\t" + url);
            System.out.println("Title Expected: \t" + title_expected);
            System.out.println("Title Actual: \t\t" + title_actual);
            System.out.println("Test Case Result: \t" + "FAILED");
        }
        driver.quit();
    }
}
