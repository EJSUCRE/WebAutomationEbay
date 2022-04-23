package com.ebay;

import com.pages.EbayHome;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EbayTest {
    private WebDriver driver;
    EbayHome ebayHome;
    @BeforeTest
    public void setUp() throws Exception{
        ebayHome = new EbayHome(driver);
        driver = ebayHome.chromeDriverConnection("Chrome");//Send the word Chrome o Firefox to choose your preferred browser to execute the test
        ebayHome.visit("https://www.ebay.com/");
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void search() throws Exception{
        ebayHome.search();
        Assert.assertEquals("La cantidad no es mayor a 2mil unidades", true, ebayHome.inventarioAdidas());
    }


}
