package com.testing.tokopedia;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import com.testing.tokopedia.constants.TokopediaAndroidElementConstants;
import com.testing.tokopedia.constants.TokopediaElementConstants;
import com.testing.tokopedia.constants.TokopediaWebElementConstants;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Login {

    @Test
    @Parameters({"platform", "usename", "password"})
    public void Login (String platform, @Optional String username,
                       @Optional String password) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            // Built to handle unable to load in login activity
            // TODO: find the solution
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utility.TapByCoordinates(538, 1078);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Handler.GetCurrentAppiumDriver().navigate().back();

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_EMAIL_AUTO,
                    TokopediaElementConstants.TEST_EMAIL);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_PASSWORD,
                    TokopediaElementConstants.TEST_PASSWORD);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_ACCOUNTS_SIGN_IN);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.LOGIN_EMAIL,
                    TokopediaElementConstants.TEST_EMAIL);

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.LOGIN_PASSWORD,
                    TokopediaElementConstants.TEST_PASSWORD);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.LOGIN_SUBMIT);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform", "usename", "password"})
    public void SummaryLogin (String platform, @Optional String username,
                              @Optional String password) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_CONTAINER_NEW_BUTTON_BUY
            );

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utility.TapByCoordinates(538, 1078);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Handler.GetCurrentAppiumDriver().navigate().back();

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_EMAIL_AUTO,
                    TokopediaElementConstants.TEST_EMAIL);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_PASSWORD,
                    TokopediaElementConstants.TEST_PASSWORD);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_ACCOUNTS_SIGN_IN);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            ArrayList<String> tabs = new ArrayList<>(
                    Handler.GetCurrentWebDriver().getWindowHandles());

            if (tabs.size() > 1) {
                Handler.GetCurrentWebDriver().switchTo().window(
                        tabs.get(WebElementConstants.SECOND_TABS));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Handler.GetCurrentWebDriver().get(Handler.GetCurrentWebDriver().getCurrentUrl());
            }

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TokopediaWebElementConstants.SUMMARY_BUY_BUTTON);

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.LOGIN_EMAIL,
                    TokopediaElementConstants.TEST_EMAIL);

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.LOGIN_PASSWORD,
                    TokopediaElementConstants.TEST_PASSWORD);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.LOGIN_SUBMIT);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

}
