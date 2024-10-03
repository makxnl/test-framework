package org.example.framework.managers;

import java.util.concurrent.TimeUnit;
import org.example.framework.utils.PropConst;

public class InitManager {

    private static final TestPropertiesManager propManager = TestPropertiesManager.getTestPropertiesManager();

    private static final DriverManager driverManager = DriverManager.getDriverManager();

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(propManager
                .getProperty(PropConst.IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(propManager
                .getProperty(PropConst.PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }

}
