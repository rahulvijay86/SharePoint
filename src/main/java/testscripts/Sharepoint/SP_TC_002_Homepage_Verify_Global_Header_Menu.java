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
 * Created by vijay.nagarajan on 09/28/2016.
 */
public class SP_TC_002_Homepage_Verify_Global_Header_Menu extends Prerequsite {


    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {
        ResultUtil.createReport("SP_TC_002_Homepage_Verify_Global_Header_Menu",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_002_Homepage_Verify_Global_Header_Menu() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To verify Global Header Menu
            _ref.sharePointHomePage.verifyGlobalHeaderMenu(driver);
            // To verify Different HomePage Menu
            _ref.sharePointHomePage.verifyDifferentHomePageMenu(driver,BrowserName);
            // To click Sign Out Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click Sign out Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify global header menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}