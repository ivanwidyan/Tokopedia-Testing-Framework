package com.testing.tokopedia;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import com.testing.tokopedia.constants.TokopediaAndroidElementConstants;
import com.testing.tokopedia.constants.TokopediaWebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Summary {

    @Test
    @Parameters({"platform"})
    public void Buy (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_CONTAINER_NEW_BUTTON_BUY
            );

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            ArrayList<String> tabs = new ArrayList<>(
                    Handler.GetCurrentWebDriver().getWindowHandles());

            for (int i = 0; i < tabs.size(); i++) {
                Log.Error("tabs: " + tabs.get(i));
            }

            Handler.GetCurrentWebDriver().switchTo().window(
                    tabs.get(WebElementConstants.SECOND_TABS));
            Log.Error("Url: " + Handler.GetCurrentWebDriver().getCurrentUrl());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Handler.GetCurrentWebDriver().get(Handler.GetCurrentWebDriver().getCurrentUrl());

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TokopediaWebElementConstants.SUMMARY_BUY_BUTTON);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

}
