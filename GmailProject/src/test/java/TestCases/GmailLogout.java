package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailLogout {
    WebDriver driver = null;
    public GmailLogout(WebDriver driver)
    {
        this.driver=driver;
    }
    By btn_menu = By.cssSelector("#gb > div.gb_Jd.gb_0d.gb_Pd > div.gb_Td.gb_Va.gb_Id.gb_Wd > div.gb_Pe > div.gb_La.gb_ed.gb_jg.gb_f.gb_xf > div > a > img");
    By btn_logout = By.cssSelector("#yDmH0d > c-wiz > div > div > div > div > div:nth-child(2) > div.EeWTFe > span > a");
    public void logout() throws InterruptedException {
        driver.findElement(btn_menu).click();
        Thread.sleep(10000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btn_logout).click();
    }
}


