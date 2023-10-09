package org.ait.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {

    public WebDriver driver;


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
     */
    public void clickWitJShExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + " , " + y + "  )");
        element.click();
    }

    /**
     * Метод продолжает логику пред идущего и необходим если нам не помогают
     * стандартные Selenium метод. Если поле спрятано под рекламным банером
     */
    public void typeWitJShExecutor(WebElement element, String text, int x, int y) {
        if (text != null) {
            clickWitJShExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }


    // метод проверяет, содержится ли нужный текст в нужном поле
    public boolean shouldHaveTest(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean isTextPresentContains(WebElement element, String book) {
        return element.getText().contains(book);
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyLinks(String linkUrl) {
        try {

            URL url = new URL(linkUrl);
            //create connection get response status code
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " " + connection.getResponseMessage() + "is a brocken link");
            } else {
                System.out.println(linkUrl + " - " + connection.getResponseMessage());
            }
        } catch (Exception ex) {
            System.out.println(linkUrl + " - " + ex.getMessage() + " is abroken link");
        }
    }
}
