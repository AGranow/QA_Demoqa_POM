package org.ait.demoqa.pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void click(WebElement element) {
        element.click();


    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
        element.click();
    }

    /**
     * Метод необходим если нам не помогают стандартные Selenium методы
     * Если поле спрятано под рекламным банером
     *
     */
    public void clickWitJShExecutor(WebElement element, int x,int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + " , " + y +"  )");
        element.click();
    }

    /**
     * Метод продолжает логику пред идущего и необходим если нам не помогают
     * стандартные Selenium метод. Если поле спрятано под рекламным банером
     *
     */
    public void typeWitJShExecutor(WebElement element,String text, int x,int y){
        if (text != null){
            clickWitJShExecutor(element,x,y);
            element.clear();
            element.sendKeys(text);
        }
    }



    public boolean shouldHaveTest(WebElement element, String text, int time){
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
