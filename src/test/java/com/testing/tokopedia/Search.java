/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.tokopedia;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import com.testing.tokopedia.constants.TokopediaAndroidElementConstants;
import com.testing.tokopedia.constants.TokopediaWebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Search {

    @Test
    @Parameters({"platform", "input"})
    public void OrderBy (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    TokopediaAndroidElementConstants.TEXT_SORT);

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    input);


        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TokopediaWebElementConstants.ORDER_BY);

            String option = "";

            if (TokopediaWebElementConstants.TEXT_PALING_SESUAI.equalsIgnoreCase(input))
                option = TokopediaWebElementConstants.ORDER_BY_PALING_SESUAI;

            else if (TokopediaWebElementConstants.TEXT_PROMO.equalsIgnoreCase(input))
                option = TokopediaWebElementConstants.ORDER_BY_PROMO;

            else if (TokopediaWebElementConstants.TEXT_PENJUALAN.equalsIgnoreCase(input))
                option = TokopediaWebElementConstants.ORDER_BY_PENJUALAN;

            else if (TokopediaWebElementConstants.TEXT_ULASAN.equalsIgnoreCase(input))
                option = TokopediaWebElementConstants.ORDER_BY_ULASAN;

            else if (TokopediaWebElementConstants.TEXT_TERBARU.equalsIgnoreCase(input))
                option = TokopediaWebElementConstants.ORDER_BY_TERBARU;

            else if (TokopediaWebElementConstants.TEXT_HARGA_TERTINGGI.equalsIgnoreCase(input))
                option = TokopediaWebElementConstants.ORDER_BY_HARGA_TERTINGGI;

            else if (TokopediaWebElementConstants.TEXT_HARGA_TERENDAH.equalsIgnoreCase(input))
                option = TokopediaWebElementConstants.ORDER_BY_HARGA_TERENDAH;

            else
                Log.Error("Sort option " + option + " is not available");

            try {
                Utility.ClickElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.CLASS_OPTION,
                        WebElementConstants.PARAM_VALUE,
                        option);
            } catch (Exception e) {
                Log.Error("Error: " + e);
            }

            Utility.GetElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TokopediaWebElementConstants.ORDER_BY);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void Select (String platform, @Optional  String input) {

        int index = Constants.FIRST_INDEX;
        if (input != null)
            index = Integer.parseInt(input);

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_RESOURCE_ID,
                    TokopediaAndroidElementConstants.RESOURCE_ID_TITLE,
                    index);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_TEXT_NEXT);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementsByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TokopediaWebElementConstants.SEARCH_ITEM_NAME,
                    index);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }


}