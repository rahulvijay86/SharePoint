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

public class SP_TC_014_UsernamePage_Verify_Language_And_Region extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_014_UsernamePage_Verify_Language_And_Region",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_014_UsernamePage_Verify_Language_And_Region() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickAboutMeLink(driver,BrowserName);
            _ref.sharePointHomePage.clickEditLink(driver,BrowserName);
            _ref.sharePointHomePage.verifyEditMenuOptions(driver);
            _ref.sharePointHomePage.clickHiddenMenuLink(driver,BrowserName);
            _ref.userPage.clickOnLanguageAndRegion(driver,BrowserName);
            _ref.userPage.clickLanguageDropdownAndChooseValue(Prerequsite.configMap.get("TC_013_Verify_Language"),driver,BrowserName);
            _ref.userPage.clickOnAddButton(driver,BrowserName);
            _ref.userPage.clickSaveAndCloseButton(driver,BrowserName);
            _ref.userPage.clickOkButton(driver,BrowserName);
            _ref.sharePointHomePage.clickEditLink(driver,BrowserName);
            _ref.sharePointHomePage.clickHiddenMenuLink(driver,BrowserName);
            _ref.userPage.clickOnLanguageAndRegion(driver,BrowserName);
            _ref.userPage.removeLanguage(Prerequsite.configMap.get("TC_013_Verify_Language"),driver,BrowserName);
            _ref.userPage.clickSaveAndCloseButton(driver,BrowserName);
            _ref.userPage.clickOkButton(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify edit menu options", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

