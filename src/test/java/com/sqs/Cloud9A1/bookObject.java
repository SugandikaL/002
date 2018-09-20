package com.sqs.Cloud9A1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class bookObject {
    WebDriver driver;

    private By originLocator = By.xpath("//*[@id=\"Origin\"]");
    private By destinationLocator = By.xpath("//*[@id=\"Destination\"]");
    private By seatLocator = By.xpath("//*[@id=\"seat\"]");
    private By classLocator = By.xpath("//*[@id=\"Flightclass\"]");
    private By bookButtonLocator = By.xpath("/html/body/div/div/div[2]/form/button");
    private By bodyTextLocator = By.tagName("body");

    private String cloud9BookHeader = "Book Flight";
    private String bookingSuccessful = "Flight booked successfully";

    public bookObject(WebDriver driver) {

        this.driver = driver;
    }

    public void clickBook(WebDriver driver){


        driver.findElement(bookButtonLocator).click();
    }

    public void assertBookHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(cloud9BookHeader));
    }

    public void assertBookSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(bookingSuccessful));
    }

    public void populateBooking(String origin,String destination,String seat,String clas){

        assertBookHeader( );
        driver.findElement(originLocator).sendKeys(origin);
        driver.findElement(destinationLocator).sendKeys(destination);
        driver.findElement(seatLocator).sendKeys(seat);
        driver.findElement(classLocator).sendKeys(clas);
        clickBook(driver);
        assertBookSuccessful();
    }


}
