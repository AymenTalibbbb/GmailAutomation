package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.concurrent.TimeUnit;



public class GmailLogin {
    WebDriver driver = null;

    public GmailLogin(WebDriver driver) {
        this.driver = driver;
    }

    String email;
    String password;

    By txt_email = By.cssSelector("#identifierId");
    By btn_nxt = By.cssSelector("#identifierNext > div > button > span");
    By txt_password = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
    By btn_login = By.cssSelector("#passwordNext > div > button > span");

    public void loginGmail() {


        try {


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("C:\\Users\\talibaym\\IdeaProjects\\Gmail\\src\\test\\Data\\LoginData.xml");

            NodeList list = doc.getElementsByTagName("loginScenario");
            for (int i = 0; i < list.getLength(); i++) {
                Node n = list.item(i);
                //System.out.println(n.getNodeName());
                Element e = (Element) n;
                email = e.getElementsByTagName("email").item(0).getTextContent();
                password = e.getElementsByTagName("password").item(0).getTextContent();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }


        driver.get("https://gmail.google.com/");
        driver.findElement(txt_email).sendKeys(email);
        driver.findElement(btn_nxt).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(txt_password).sendKeys(password);
        driver.findElement(btn_login).click();
    }
    public void login_validation ()
    {

        String ExpectedUrl = "https://mail.google.com/mail";
        String ActualUrl = driver.getCurrentUrl();
        System.out.println(ActualUrl);
        Assert.assertEquals(ActualUrl, ExpectedUrl, "can't logged into the system");


    }

}




