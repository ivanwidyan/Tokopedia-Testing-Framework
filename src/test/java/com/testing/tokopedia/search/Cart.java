package com.testing.tokopedia.search;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import com.testing.tokopedia.constants.TokopediaAndroidElementConstants;
import com.testing.tokopedia.constants.TokopediaConfigConstants;
import com.testing.tokopedia.constants.TokopediaElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cart {

    @Test
    @Parameters({"platform", "input"})
    public void Note (String platform, @Optional String input) {

        if (input == null) {
            input = "testing";
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "com.tokopedia.tkpd:id/et_remark",
                    input);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "note-text",
                    input);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void AddQuantity (String platform, @Optional String input) {

        int quantity = 1;
        if (input != null) {
            quantity = Integer.parseInt(input);
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            for (int i = 0; i < quantity; i++) {
                Utility.ClickElementById(
                        Handler.GetCurrentAppiumDriver(),
                        "com.tokopedia.tkpd:id/image_button_plus");
            }

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            for (int i = 0; i < quantity; i++) {
                Utility.ClickElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        "cart-plus-button quantity-button");
            }

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform"})
    public void Checkout (String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "com.tokopedia.tkpd:id/new_button_save");

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "com.tokopedia.tkpd:id/go_to_courier_page_button");

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_TEXT_NEXT);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_TEXT_NEXT);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "btn proceed-button");

            try {
                Utility.ClickElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        "hopscotch-nav-button next hopscotch-next",
                        TokopediaConfigConstants.TOOLTIP_TIMEOUT);

                Utility.ClickElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        "hopscotch-nav-button next hopscotch-next",
                        TokopediaConfigConstants.TOOLTIP_TIMEOUT);
            } catch (Exception e) {
                Log.Debug("Tooltip is not available");
            }

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

}
