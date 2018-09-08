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
import com.testing.tokopedia.constants.TokopediaAndroidElementConstants;
import org.testng.SkipException;
import org.testng.annotations.*;

public class SplashScreen {

    @Test
    @Parameters({"platform"})
    public void SkipSplashScreen (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    TokopediaAndroidElementConstants.ID_SKIP
            );

        } else {
            throw new SkipException("This test only for Android!");
        }
    }
}
