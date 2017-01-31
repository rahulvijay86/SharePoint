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
 * Created by vijay.nagarajan on 10/18/2016.
 */

public class SP_TC_017_Branding_Verify_User_Dropdown_Options extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_017_Branding_Verify_User_Dropdown_Options",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_017_Branding_Verify_User_Dropdown_Options() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));

            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To verify User dropdown menu
            _ref.sharePointHomePage.verifyUserDropdownMenu(driver);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify user dropdown options", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

