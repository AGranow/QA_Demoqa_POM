package org.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage login(String userName, String password) {
//      typeWitJShExecutor(userNameField, userName, 0, 100);  // необходимо если поле спрятано под банером
        type(userNameField, userName);
        type(passwordField, password);
        click(loginButton);
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String userName, String password) {
        //      typeWitJShExecutor(userNameField, userName, 0, 100);  // необходимо если поле спрятано под банером
        type(userNameField, userName);
        type(passwordField, password);
        click(loginButton);
        return this;
    }

}
