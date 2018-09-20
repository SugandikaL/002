package com.sqs.Cloud9A1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Unit test for simple App.
 */
public class AppTestA
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
    driver.findElement(By.linkText("Register")).click();

    registrationObject registrationPage;
    registrationPage = new registrationObject(driver);
    registrationPage.populateRegistration("Su","Liyanage","suliyana10@gmail.com","1234");
    Thread.sleep(3000);

    }


    @Test
    public void LoginCustomer() throws InterruptedException {


       loginCustomer loginPage;
       loginPage = new loginCustomer(driver);
       loginPage.populateLogin("suliyanage1@gmail.com","1234");

        Thread.sleep(3000);
    }
    @Test
    public void bookObject() throws InterruptedException {
        loginCustomer loginPage;
        loginPage = new loginCustomer(driver);
        loginPage.populateLogin("suliyanage1@gmail.com", "1234");

        driver.findElement(By.xpath("/html/body/center[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[1]/ul/li[1]/a")).click();
        Thread.sleep(1000);

        bookObject bookPage;
        bookPage = new bookObject(driver);
        bookPage.populateBooking("", "Dur", "29B", "E");
        Thread.sleep(2000);
    }

    @Test
    public void updateSeatNumber() throws InterruptedException {

        loginCustomer loginPage;
        loginPage = new loginCustomer(driver);
        loginPage.populateLogin("suliyanage1@gmail.com", "1234");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/center[3]/a")).click();
        Thread.sleep(1000);

        String flightID = "462";
        String newSeatNumber = "T87";
        Thread.sleep(2000);

        itineraryObject itineraryPage;
        itineraryPage = new itineraryObject(driver);
        String editURL = itineraryPage.scanBookingsAndFindFlightID(flightID);
        System.out.println("editURL is: " + editURL);

        if (editURL.equals("notfound")) {
            System.out.println("flightID: " + flightID + " not found" );
        } else {
            driver.get(editURL);
            Thread.sleep(3000);
            // TODO create new object for editFlight class
            // TODO call the update method

            EditObject editPage;
            editPage = new EditObject(driver);
            editPage.editBooking(driver, newSeatNumber);
            Thread.sleep(2000);
        }

        //@Test
        //public void deleteFlight() throws InterruptedException {

        //}
    }

    @After
    public void tearDown()
    {
       driver.close();
    }

}




