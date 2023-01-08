package calculator;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public AndroidDriver driver;

    public BasePage(AndroidDriver driver){
        this.driver = driver;
    }
    public WebElement find(By by){
        return driver.findElement(by);
    }
    public void click(By by){
        find(by).click();
    }
    public void inputText(By by, String text){
        find(by).sendKeys(text);
    }
    public String getText(By by){
        return find(by).getText();
    }
    public void hold(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    public void clear(By by){
        find(by).clear();
    }

    public void longTap(By by){
        TouchAction touch = new TouchAction<>(driver);
        touch.longPress(PointOption.point(find(by).getLocation()))
                .waitAction(WaitOptions.waitOptions(Duration.of(10, ChronoUnit.SECONDS)))
                .release()
                .perform();
    }
}
