package calculator.testcases;

import calculator.BasePage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BasePage{
    @BeforeTest
    public void setUp() throws Exception {
        androidInitiate();
    }
    @AfterTest
    public void tearDown(){
        androidExit();
    }

    @Test
    public void login(){
        inputText(By.id("com.isl.simpleapp:id/username"), "admin");
        inputText(By.id("com.isl.simpleapp:id/password"), "admin");
        click(By.id("com.isl.simpleapp:id/login"));
    }
}
