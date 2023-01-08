package calculator.testcases;

import calculator.BasePage;
import calculator.init.AndroidInit;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BasePage{
    @BeforeTest
    public void setUp() throws Exception {
        androidInitiate();
        AndroidInit.open();
    }
    @AfterTest
    public void tearDown(){
        AndroidInit.quit();
    }

    @Test
    public void login(){
        inputText(By.id("com.isl.simpleapp:id/username"), "admin");
        inputText(By.id("com.isl.simpleapp:id/password"), "admin");
        click(By.id("com.isl.simpleapp:id/login"));
    }
}
