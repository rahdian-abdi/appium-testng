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

public class CalculationTest {
//    public AndroidDriver driver;
    public BasePage base;
    @BeforeTest
    public void setUp() throws Exception {
        AndroidInit.open();
//        driver = AndroidInit.driver;
        base = AndroidInit.base;

        base.inputText(By.id("com.isl.simpleapp:id/username"), "admin");
        base.inputText(By.id("com.isl.simpleapp:id/password"), "admin");
        base.click(By.id("com.isl.simpleapp:id/login"));
        base.hold(30);
    }
    @AfterTest
    public void tearDown(){
        AndroidInit.quit();
    }
    @BeforeMethod
    public void inputNumber(){
        base.inputText(By.id("com.isl.simpleapp:id/et_1"), Integer.toString(10));
        base.inputText(By.id("com.isl.simpleapp:id/et_2"), Integer.toString(5));
        base.click(By.id("com.isl.simpleapp:id/spinner_1"));
    }
    @AfterMethod
    public void equals(){
        base.clear(By.id("com.isl.simpleapp:id/et_1"));
        base.clear(By.id("com.isl.simpleapp:id/et_2"));
    }
    @Test(dataProvider = "Operator", dataProviderClass = CustomDataProvider.class)
    public void calculate(String operator){
        switch (operator){
            case "+":
                base.click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"));
                base.click(By.id("com.isl.simpleapp:id/acb_calculate"));
                assertEquals("Hasil : "+15, base.getText(By.id("com.isl.simpleapp:id/tv_result")));
                break;
            case "-":
                base.click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
                base.click(By.id("com.isl.simpleapp:id/acb_calculate"));
                assertEquals("Hasil : "+5, base.getText(By.id("com.isl.simpleapp:id/tv_result")));
                break;
            case "x":
                base.click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]"));
                base.click(By.id("com.isl.simpleapp:id/acb_calculate"));
                assertEquals("Hasil : "+50, base.getText(By.id("com.isl.simpleapp:id/tv_result")));
                break;
            case "/":
                base.click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]"));
                base.click(By.id("com.isl.simpleapp:id/acb_calculate"));
                assertEquals("Hasil : "+2, base.getText(By.id("com.isl.simpleapp:id/tv_result")));
        }
    }
}
