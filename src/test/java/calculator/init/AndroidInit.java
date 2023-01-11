package calculator.init;

import calculator.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidInit {
    AndroidDriver driver;

    public AndroidInit(AndroidDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void quit(){
        driver.quit();
        driver = null;
    }
}
