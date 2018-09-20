package com.sqs.Cloud9A1;

import org.junit.*;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    static WebDriver driver;
    private String registrationSuccessful = "Registration Successful";
    private By bodyTextLocator = By.tagName("body");
    private String cloud9RegisterHeader = "Cloud9 - Register";



    @Before
    public void testSetup() throws InterruptedException {
        System.out.println("In test set up");
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "http://10.9.10.39:81/sqlite/Main/login.html";
        String expectedTitle = "Cloud9 Airlines";
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title is : " +actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @BeforeClass
    public static void browserSetup()
    {

    }

    @Test
    public void shouldRegisterNewCustomer() throws InterruptedException {


        driver.findElement(By.xpath("/html/body/div/form/center/a")).click();
        driver.findElement(By.xpath("//*[@id=\"inputfirstname\"]")).sendKeys("Sugandika");
        driver.findElement(By.xpath("//*[@id=\"inputlastname\"]")).sendKeys("Liyanage");
        driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("sugandika21@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();

        String bodyText = driver.findElement(bodyTextLocator).getText();
        //System.out.println("Bodytext");
        Assert.assertTrue("Text not found !", bodyText.contains(registrationSuccessful));
        Thread.sleep(10000);
    }


    @Test
    public void LoginCustomer() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("sugandika1@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Thread.sleep(3000);
    }

    @After
    public void tearDown()
    {
       driver.close();
    }

}




