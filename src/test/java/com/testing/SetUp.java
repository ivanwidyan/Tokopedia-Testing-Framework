/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing;

import com.testing.constants.ConfigConstants;
import com.testing.logging.Log;
import com.testing.tokopedia.constants.TokopediaConfigConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetUp {

    @BeforeSuite
    public void Init() {
        Log.Debug("SetUp initiated");
        Handler.init();
    }

    @BeforeTest
    @Parameters({"platform", "browser", "devicename", "udid", "ip", "port"})
    public void SetUp(String platform, @Optional String browser, @Optional String devicename,
                      @Optional String udid, @Optional String ip, @Optional String port) throws Exception {

        String info = "";

        Log.Debug("Test platform: " + platform);

        if (platform.equalsIgnoreCase(ConfigConstants.PLATFORM_ANDROID)) {
            if (com.testing.Handler.GetCurrentAppiumDriver() == null) {
                if (devicename == null)
                    devicename = TokopediaConfigConstants.DEVICE_NAME;

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ConfigConstants.CAPABILITIES_DEVICE_NAME, devicename);

                // 2018/09/07: Deprecated in Appium 1.9.0
                /*capabilities.setCapability(CapabilityType.BROWSER_NAME,
                        TokopediaConfigConstants.BROWSER_NAME);*/

                capabilities.setCapability(ConfigConstants.CAPABILITIES_PLATFORM_NAME,
                        TokopediaConfigConstants.PLATFORM_NAME);

                capabilities.setCapability(ConfigConstants.CAPABILITIES_APP_PACKAGE,
                        TokopediaConfigConstants.APP_PACKAGE);

                capabilities.setCapability(ConfigConstants.CAPABILITIES_APP_ACTIVITY,
                        TokopediaConfigConstants.APP_ACTIVITY);

                if (udid != null)
                    capabilities.setCapability(ConfigConstants.CAPABILITIES_UDID, udid);

                if (ip == null)
                    ip = TokopediaConfigConstants.DEFAULT_IP;

                if (port == null)
                    port = TokopediaConfigConstants.DEFAULT_PORT;

                String url = "http://" + ip + ":" + port + "/wd/hub";
                Handler.SetCurrentAppiumDriver(new AndroidDriver(new URL(url), capabilities));

                info = "SetUp Appium Driver for Device = " + com.testing.Handler.GetCurrentAppiumDriver()
                        .getCapabilities().getCapability(ConfigConstants.CAPABILITIES_DEVICE_NAME);
                Log.Debug(info);

            } else {
                info = "Duplicate Appium driver in the same thread";
                Log.Error(info);
            }

        } else if (platform.equalsIgnoreCase(ConfigConstants.PLATFORM_WEB)) {
            System.setProperty(ConfigConstants.GECKO_DRIVER_PROPERTY,
                    ConfigConstants.GECKO_DRIVER_PATH);
            Handler.SetCurrentWebDriver(new FirefoxDriver());

            Handler.GetCurrentWebDriver().manage().timeouts().implicitlyWait(
                    ConfigConstants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);

            Handler.GetCurrentWebDriver().get(TokopediaConfigConstants.URL);
        }
    }

    @AfterTest
    public void AfterTest() {
        if (Handler.GetCurrentAppiumDriver() != null) {
            String info = "Quit Driver for Device = " + com.testing.Handler.GetCurrentAppiumDriver()
                    .getCapabilities().getCapability(ConfigConstants.CAPABILITIES_DEVICE_NAME);
            Log.Debug(info);
            Handler.GetCurrentAppiumDriver().quit();
        }

        if (Handler.GetCurrentWebDriver() != null) {
            String info = "Quit Driver for Web Driver = " + com.testing.Handler.GetCurrentWebDriver();
            Log.Debug(info);
            Handler.GetCurrentWebDriver().quit();
        }
    }

    @AfterSuite
    public void AfterSuite() throws Exception {
        String info = "Clear Driver Hashmap";
        Log.Debug(info);
        Handler.ClearAppiumDriverHashmap();
        Handler.ClearWebDriverHashmap();
    }
}
