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
 * Created by vijay.nagarajan on 08/19/2016.
 */

public class SP_TC_014_Project_Verification_Of_Widgets extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_014_Project_Verification_Of_Widgets",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_014_Project_Verification_Of_Widgets() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.projectPage.clickProjectMenu(driver, BrowserName);
            _ref.projectPage.clickProjectTitleMenu(driver, BrowserName,Prerequsite.configMap.get("Enter_Project_Title"));
            _ref.projectPage.verifyWidgetMenuInProjectPage(driver, BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify widgets", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}



