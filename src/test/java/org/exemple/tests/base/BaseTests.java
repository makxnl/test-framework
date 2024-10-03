package org.exemple.tests.base;

import org.example.framework.managers.DriverManager;
import org.example.framework.managers.InitManager;
import org.example.framework.managers.PageManager;
import org.example.framework.managers.TestPropertiesManager;
import org.example.framework.utils.PropConst;
import org.junit.jupiter.api.AfterAll;
 import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    private final TestPropertiesManager propManager = TestPropertiesManager.getTestPropertiesManager();

    protected PageManager app = PageManager.getPageManager();

    @BeforeAll
    static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    void beforeEach() {
        DriverManager.getDriverManager().getDriver().get(propManager.getProperty(PropConst.BASE_URL));
    }

    @AfterAll
    static void afterEach() {
        InitManager.quitFramework();
    }

}
