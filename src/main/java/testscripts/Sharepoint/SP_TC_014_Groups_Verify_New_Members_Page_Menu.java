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
 * Created by vijay.nagarajan on 09/01/2016.
 */

public class SP_TC_014_Groups_Verify_New_Members_Page_Menu extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_014_Groups_Verify_New_Members_Page_Menu",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_014_Groups_Verify_New_Members_Page_Menu() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.groupsPage.clickGroupsMenu(driver, BrowserName);
            _ref.groupsPage.clickMenuInGroupsPage(driver, BrowserName, Prerequsite.configMap.get("TC_001_Click_Group_Menu"));
            _ref.groupsPage.clickMembersMenuInGroupsPage(driver, BrowserName);
            _ref.groupsPage.clickNewMembersMenuInGroupsPage(driver, BrowserName);
            _ref.groupsPage.verifyTopMembersMenuInGroupsPage(driver, Prerequsite.configMap.get("TC_013_Verify_User_Name"));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Members menu and verify option under Groups Page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}




