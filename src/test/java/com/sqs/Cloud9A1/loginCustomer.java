package com.sqs.Cloud9A1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class loginCustomer {

        WebDriver driver;

        private By emailLocator = By.xpath("//*[@id=\"inputEmail\"]");
        private By passwordLocator = By.xpath("//*[@id=\"inputPassword\"]");
        private By loginButtonLocator = By.xpath("/html/body/div/form/button");
        private By bodyTextLocator = By.tagName("body");

        private String cloud9LoginHeader = "Cloud9 - Sign in";
        private String welcomeSu = "Welcome Su";

        public loginCustomer(WebDriver driver) {

            this.driver = driver;
        }
    public void clickLogin(WebDriver driver){

        driver.findElement(loginButtonLocator).click();
    }
    public void assertLoginHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(cloud9LoginHeader));
    }
    public void assertLoginSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(welcomeSu));
    }
    public void populateLogin(String emailAddress, String password){

        assertLoginHeader();

        driver.findElement(emailLocator).sendKeys(emailAddress);
        driver.findElement(passwordLocator).sendKeys(password);
        clickLogin(driver);
        assertLoginSuccessful();
    }
}