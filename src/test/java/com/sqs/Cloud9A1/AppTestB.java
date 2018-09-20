package com.sqs.Cloud9A1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTestB
{
    static WebDriver driver;
    private String registrationSuccessful = "Registration Successful";
    private By bodyTextLocator = By.tagName("body");
    private String cloud9RegisterHeader = "Cloud9 - Register";

    @Before
    public void testSetup() throws InterruptedException {
        System.out.println("In testSetup ");
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        String baseUrl = "http://10.9.10.39:81/sqlite/Main/login.html";
        //String baseUrl = "http://192.168.56.1:81/sqlite/Main/login.html";

        String expectedTitle = "Cloud9 Airlines";
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title is: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(5000);
    }

    @BeforeClass
    public static void browserSetup()
    {

    }

    @Test
    public void shouldRegisterNewCustomer()
    {
        // Click the register tab on the login screen (Login screen is entry into system)
        driver.findElement(By.linkText("Register")).click();

        registrationObject registrationPage;
        registrationPage = new registrationObject(driver);
        registrationPage.populateRegistration("Wayne","Sinclair", "ws1009@sqs.com", "xxx");
    }

    @Test
    public void shouldLoginCustomer()
    {
        loginCustomer loginPage;
        loginPage = new loginCustomer(driver);
        loginPage.populateLogin("suliyanage1@gmail.com", "1234");
    }

    @Test
    public void bookingTest() throws InterruptedException {
        //Utilities.login(driver,"wsi@netactive.co.za", "xxx");
        //booking();

        loginCustomer loginPage;
        loginPage = new loginCustomer(driver);
        loginPage.populateLogin("suliyanage1@gmail.com", "1234");

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
        driver.findElement(By.xpath("/html/body/center[3]/a")).click();

        String flightID = "326";
        String newSeatNumber = "A32";

        itineraryObject itineraryPage;
        itineraryPage = new itineraryObject(driver);
        String editURL = itineraryPage.scanBookingsAndFindFlightID(flightID);
        System.out.println("editURL is: " + editURL);

        if (editURL.equals("notfound")) {
            System.out.println("flightID: " + flightID + " not found" );
        } else {
            driver.get(editURL);
            // TODO create new object for editFlight class
            // TODO call the update method

            EditObject editPage;
            editPage = new EditObject(driver);
            editPage.editBooking(driver, newSeatNumber);
        }
    }



    @After
    public void tearDown()
    {
        // driver.close();
    }
}
