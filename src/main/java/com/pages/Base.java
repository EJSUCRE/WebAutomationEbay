package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver driverConnection(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","./src/drivers/chrome/chromedriver.exe");
            driver= new ChromeDriver();
            return driver;
        }else if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","./src/drivers/firefox/geckodriver.exe");
            driver= new FirefoxDriver();
            return driver;
        }else{
            System.out.println("El navegadore especificado no existe, comunícate con el administrador del código");
            return null;
        }
    }

    public void visit(String url){
        driver.get(url);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public void type(By locator, String inputText) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void wait(By locator, int time){
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
