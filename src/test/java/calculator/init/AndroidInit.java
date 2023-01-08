package calculator.init;

import calculator.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidInit {
    public static void open() {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
//        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//        cap.setCapability(
//                MobileCapabilityType.APP,
//                "D:\\QA Engineer\\Software Quality Assurance Engineer Path\\Mobile Automation\\apk\\sample-apk.apk");
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
//
//        URL url = new URL("http://0.0.0.0:4723/wd/hub");
//        try {
//            driver = new AndroidDriver(url, cap);
//        } catch (Exception e){
//            String msg = e.getMessage();
//            System.out.println(msg);
//        }
        BasePage.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public static void quit(){
        BasePage.driver.quit();
        BasePage.driver = null;
    }
}
