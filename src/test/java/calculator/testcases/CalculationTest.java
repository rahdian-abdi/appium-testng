package calculator.testcases;

import calculator.BasePage;
import calculator.dataprovider.CustomDataProvider;
import calculator.init.AndroidInit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CalculationTest extends BasePage{
    @BeforeTest
    public void setUp() throws Exception {
        androidInitiate();
        inputText(By.id("com.isl.simpleapp:id/username"), "admin");
        inputText(By.id("com.isl.simpleapp:id/password"), "admin");
        click(By.id("com.isl.simpleapp:id/login"));
        hold(30);
    }
    @AfterTest
    public void tearDown(){
        androidExit();
    }
    @BeforeMethod
    public void inputNumber(){
        inputText(By.id("com.isl.simpleapp:id/et_1"), Integer.toString(10));
        inputText(By.id("com.isl.simpleapp:id/et_2"), Integer.toString(5));
        click(By.id("com.isl.simpleapp:id/spinner_1"));
    }
    @AfterMethod
    public void equals(){
        clear(By.id("com.isl.simpleapp:id/et_1"));
        clear(By.id("com.isl.simpleapp:id/et_2"));
    }
    @Test(dataProvider = "Operator", dataProviderClass = CustomDataProvider.class)
    public void calculate(String operator){
        switch (operator){
            case "+":
                click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"));
                click(By.id("com.isl.simpleapp:id/acb_calculate"));
                assertEquals("Hasil : "+15, getText(By.id("com.isl.simpleapp:id/tv_result")));
                break;
            case "-":
                click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
                click(By.id("com.isl.simpleapp:id/acb_calculate"));
                assertEquals("Hasil : "+5, getText(By.id("com.isl.simpleapp:id/tv_result")));
                break;
            case "x":
                click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]"));
                click(By.id("com.isl.simpleapp:id/acb_calculate"));
                assertEquals("Hasil : "+50, getText(By.id("com.isl.simpleapp:id/tv_result")));
                break;
            case "/":
                click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]"));
                click(By.id("com.isl.simpleapp:id/acb_calculate"));
                assertEquals("Hasil : "+2, getText(By.id("com.isl.simpleapp:id/tv_result")));
        }
    }
}
