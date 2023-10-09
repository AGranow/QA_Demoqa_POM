package org.ait.demoqa.pages.bookStore;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BookStorePage extends BasePage {


    public BookStorePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage enterBookName(String book) {
        type(searchBox, book);

        return this;
    }


    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement bookName;

    public BookStorePage verifyBookName(String book) {
        Assert.assertTrue(isTextPresentContains(bookName, book));
        return this;
    }


    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }

    public BookStorePage clickOnBookName() {
        click(bookName);

        return this;
    }
//
//    @FindBy(css = ".text-right fullButton")
//    WebElement addBookButton;

    @FindBy(css = ".text-right.fullButton")
    WebElement addBookButton;

    public BookStorePage addToCollection() {
        clickWitJShExecutor(addBookButton, 0, 500);
        pause(300);
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.alertIsPresent()).accept();
        driver.switchTo().alert().accept();
        return this;
    }
}
