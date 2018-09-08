package com.testing.tokopedia.search;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.tokopedia.constants.TokopediaAndroidElementConstants;
import com.testing.tokopedia.constants.TokopediaWebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Checkout {

    @Test
    @Parameters({"platform", "input"})
    public void ChooseCourrier (String platform, @Optional String input) {

        // TODO: Should have pick first row as default
        if (input == null) {
            input = "GO-JEK";
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    TokopediaAndroidElementConstants.TEXT_PILIH_KURIR);

            // TODO: Remove the hardcode
            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    "(Rp 17.000)");

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TokopediaWebElementConstants.CHECKOUT_TOGGLE_HANDLER);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_SHIPPER_NAME,
                    input);

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
                    TokopediaAndroidElementConstants.ID_TV_SELECT_PAYMENT_METHOD
            );

            try {
                Thread.sleep(5000);
            } catch (Exception e) {}

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TokopediaWebElementConstants.BUTTON_PROCEED_BUTTON);

            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

}
