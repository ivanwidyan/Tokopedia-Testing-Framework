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
import com.testing.constants.WebElementConstants;

import com.testing.tokopedia.constants.TokopediaWebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Home {

    @Test
    @Parameters({"platform", "input"})
    public void Search (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.ID_SEARCH_KEYWORD,
                    input);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.ID_CAT_SELECT);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void SetCategory (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.ID_CAT_SELECT);

            if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            }

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void SetSearchCategory (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    TokopediaWebElementConstants.ID_CAT_SELECT);

            if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Pria".equalsIgnoreCase(input)) {

            } else if ("Fashion Muslim".equalsIgnoreCase(input)) {

            } else if ("Fashion Anak".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            } else if ("Fashion Wanita".equalsIgnoreCase(input)) {

            }

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

}
