package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class ComposeEmail {
    WebDriver driver = null;
    public ComposeEmail(WebDriver driver)
    {
        this.driver=driver;
    }
    By btn_compose = By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div");

    /**
     * Click on username textbox
     */
    By txt_username = By.xpath("//textarea[@name='to']");

    /**
     * Enter text on subject text box
     */
    By txt_subject = By.xpath("//input[@name='subjectbox']");

    /**
     * Enter text on body
     */
    By txt_body=  By.xpath("//div[@aria-label='Message Body']");

    /**
     * Click on attachment button
     */
    By btn_attachment = By.xpath("//div[@class='wG J-Z-I' and @aria-label='Attach files']");


    /**
     * Click on send button
     */

    By btn_send = By.xpath("//*[@id=\":8l\"]");
    public void ComposingEmail() throws IOException, InterruptedException {
        driver.findElement(btn_compose).click();
        driver.findElement(txt_username).sendKeys("usererror794@gmail.com");
        driver.findElement(txt_subject).sendKeys("file");
        driver.findElement(txt_body).sendKeys("file to be sent");
        driver.findElement(btn_attachment).click();
        //AutoIt script
        Runtime.getRuntime().exec("D:\\FileUploadScript.exe");
        Thread.sleep(10000);
        driver.findElement(btn_send).click();
    }
    public void validate_compose_email()
    {
        String exp_msg = driver.findElement(By.cssSelector("span > span.bAq")).getText();
        String act_msg = "Sending...";
        Assert.assertEquals(act_msg,exp_msg,"mail wasn't sent");

    }
}






