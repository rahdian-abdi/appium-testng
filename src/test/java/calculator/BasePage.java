package calculator;

import calculator.init.AndroidInit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public AndroidDriver driver;

    public AndroidInit init;

    public void androidInitiate() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability(
                MobileCapabilityType.APP,
                "D:\\QA Engineer\\Software Quality Assurance Engineer Path\\Mobile Automation\\apk\\sample-apk.apk");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        try {
            driver = new AndroidDriver(url, cap);
        } catch (Exception e){
            String msg = e.getMessage();
            System.out.println(msg);
        }
        init = new AndroidInit(driver);
        init.open();
    }
    public void androidExit(){
        init.quit();
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
