package org.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage{




    public SidePanel(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".show #item-0")
    WebElement login;

    public LoginPage selectLogin(){
        clickWitJShExecutor(login,0,600);
        return new LoginPage(driver);
    }
}
