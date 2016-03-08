/**
 * Created by Artem on 3/7/16.
 */
package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Single_Title_Validation {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();   //Version 1.1 :: Firefox
        // WebDriver driver = new HtmlUnitDriver(); // Version 1.2 :: HtmlUnit
        String url = "http://learn2test.net";
        String title_expected = "learn2test.net";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String title_actual = driver.getTitle();

        if (title_expected.equals(title_actual)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");

        }
        driver.quit();
    }
}