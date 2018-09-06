/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.tokopedia;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;

import com.testing.tokopedia.constants.TokopediaAndroidElementConstants;
import com.testing.tokopedia.constants.TokopediaElementConstants;
import com.testing.tokopedia.constants.TokopediaWebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Home {

    @Test
    @Parameters({"platform", "input"})
    public void Search (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_SEARCH_CONTAINER);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_TEXT_NEXT);

            input = input + Constants.ENTER;
            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_SEARCH_CONTAINER,
                    input);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_TEXT_NEXT);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.SEARCH_KEYWORD,
                    input);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TokopediaWebElementConstants.SEARCH_NEW_BUTTON);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }
}
