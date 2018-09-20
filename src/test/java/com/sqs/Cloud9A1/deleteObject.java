package com.sqs.Cloud9A1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class deleteObject {
    WebDriver driver;


    public deleteObject(WebDriver driver) {

        this.driver = driver;
    }
    public void assertDeletePage(){


        By bodyTextLocator = By.tagName("body");

        String bodyText = driver.findElement(bodyTextLocator).getText();

    }

    public void assertFlightSuccessfullyDeleted(){

        String editHeader = "Flight successfully deleted.";
        By bodyTextLocator = By.tagName("body");

        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(editHeader));

    }
    public void editBooking(WebDriver driver,  String newSeat) throws InterruptedException {

        assertDeletePage();

        //Thread.sleep(5000);

        //driver.findElement(deleteButton).click();

        assertFlightSuccessfullyDeleted();
    }
}
