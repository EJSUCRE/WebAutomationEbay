package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayHome extends Base {
    By searchBox = By.cssSelector("#gh-ac");
    By searchButton = By.id("gh-btn");
    By adidasBrand = By.cssSelector("#x-refine__group_1__1 > ul > li:nth-child(1) > div > a > div > div > div > span.cbx.x-refine__multi-select-cbx");
    By adidasCheck = By.cssSelector("#x-refine__group_1__1 > ul > li:nth-child(1) > div > a > div > span > input");
    By inventario = By.cssSelector("#mainContent > div.s-answer-region.s-answer-region-center-top > div > div.clearfix.srp-controls__row-2 > div:nth-child(1) > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)");

    public EbayHome(WebDriver driver) {
        super(driver);
    }

    public void searchByBrandAndSelect(){
        wait(searchBox,5);
        click(searchBox);

        type(searchBox,"shoes");

        wait(searchButton,5);
        click(searchButton);

        wait(adidasBrand,5);
        click(adidasCheck);

        wait(inventario,5);
    }

    public boolean inventarioAdidas(){
        int cantidadIn=Integer.parseInt(getText(inventario).replace(".",""));
        if(cantidadIn>2000){
        return true;
        }else{
            return false;
        }
    }

}
