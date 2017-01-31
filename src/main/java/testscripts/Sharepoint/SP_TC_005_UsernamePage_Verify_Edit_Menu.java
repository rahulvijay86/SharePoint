package testscripts.Sharepoint;

import actions.Browser;
import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import util.DataProviderUtil;

import java.util.Map;

/**
 * Created by vijay.nagarajan on 10/11/2016.
 */

public class SP_TC_005_UsernamePage_Verify_Edit_Menu extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_005_UsernamePage_Verify_Edit_Menu",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_005_UsernamePage_Verify_Edit_Menu() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click About me link
            _ref.sharePointHomePage.clickAboutMeLink(driver, BrowserName);
            // to verify Edit menu
            _ref.sharePointHomePage.verifyEditMenuPresence(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify edit menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

