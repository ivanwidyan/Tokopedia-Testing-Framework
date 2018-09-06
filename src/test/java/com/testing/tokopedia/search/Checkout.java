package com.testing.tokopedia.search;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.tokopedia.constants.TokopediaAndroidElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Checkout {

    @Test
    @Parameters({"platform", "input"})
    public void ChooseCourrier (String platform, @Optional String input) {

        if (input == null) {
            input = "testing";
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    "Pilih Kurir");

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    "(Rp 17.000)");

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "toggle-handler");

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    "data-shipper-name",
                    "GO-JEK");

            /*Utility.ClickElementById(
                    Handler.GetCurrentWebDriver(),
                    "gojek-pinpoint");*/

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform"})
    public void Pay (String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById (
                    Handler.GetCurrentAppiumDriver(),
                    "com.tokopedia.tkpd:id/tv_select_payment_method"
            );

            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "btn proceed-button");

            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

}
