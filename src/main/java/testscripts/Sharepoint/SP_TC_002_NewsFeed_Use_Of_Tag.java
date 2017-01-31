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
 * Created by vijay.nagarajan on 08/03/2016.
 */
public class SP_TC_002_NewsFeed_Use_Of_Tag extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_002_NewsFeed_Use_Of_Tag",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_002_NewsFeed_Use_Of_Tag() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            _ref.newsFeedPage.startConversation(driver, BrowserName,Prerequsite.configMap.get("TC_002_Enter_Tag"));
            _ref.newsFeedPage.clickOnPostButton(driver, BrowserName);
            _ref.newsFeedPage.clickOnEveryOne(driver, BrowserName);
            _ref.newsFeedPage.selectTag(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.close();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify the Site Contents menu", "" + e.getMessage(), driver);
            driver.close();
        }
    }

}