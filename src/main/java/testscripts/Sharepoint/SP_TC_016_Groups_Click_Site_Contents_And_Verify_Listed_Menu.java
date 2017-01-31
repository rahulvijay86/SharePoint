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

public class SP_TC_016_Groups_Click_Site_Contents_And_Verify_Listed_Menu extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_016_Groups_Click_Site_Contents_And_Verify_Listed_Menu",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_016_Groups_Click_Site_Contents_And_Verify_Listed_Menu() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.groupsPage.clickGroupsMenu(driver,BrowserName);
            _ref.groupsPage.clickMenuInGroupsPage(driver,BrowserName,Prerequsite.configMap.get("TC_001_Click_Group_Menu"));
            _ref.groupsPage.clickSiteContentMenuInGroupsPage(driver,BrowserName);
            _ref.groupsPage.verifySiteContentsOptionMenu(driver);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Site Contents menu and verify options under Groups Page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


