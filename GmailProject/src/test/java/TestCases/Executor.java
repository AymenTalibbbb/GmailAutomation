package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class Executor extends Extent_Report {
    @Test(priority = 1)
    public void LoginTest() {
        try {
            test = extent.createTest("gmail automation with AutoIT");
            BrowserFactory browser = new BrowserFactory("Chrome");
            test.log(Status.INFO, "browser and url is initiated");
            GmailLogin login = new GmailLogin(browser.driver);
            test.log(Status.INFO,"user is logged into the system");
            GmailLogout logout = new GmailLogout(browser.driver);
            ComposeEmail compose = new ComposeEmail(browser.driver);
            test.log(Status.INFO,"user has composed an email");
            login.loginGmail();
            compose.ComposingEmail();
            compose.validate_compose_email();
            test.log(Status.PASS,"Email has been sent successfully with an attachment");
            //logout.logout();

        } catch (Exception e) {
            test.log(Status.FAIL, e.getMessage());
        }
    }
}

