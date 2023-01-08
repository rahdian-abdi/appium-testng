package calculator.testcases;

import calculator.BasePage;
import calculator.init.AndroidInit;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    AndroidDriver driver;
    BasePage base;
    @BeforeTest
    public void setUp() throws Exception {
        AndroidInit.open();
        driver = AndroidInit.driver;
        base = AndroidInit.base;
    }
    @AfterTest
    public void tearDown(){
        AndroidInit.quit();
    }

    @Test
    public void login(){
        base.inputText(By.id("com.isl.simpleapp:id/username"), "admin");
        base.inputText(By.id("com.isl.simpleapp:id/password"), "admin");
        base.click(By.id("com.isl.simpleapp:id/login"));
    }
}
