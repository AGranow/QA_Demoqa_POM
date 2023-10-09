package org.ait.demoqa.pages;

import org.ait.demoqa.pages.bookStore.LoginPage;
import org.ait.demoqa.pages.bookStore.ProfilePage;
import org.ait.demoqa.pages.elements.BrokenLinksImagesPage;
import org.ait.demoqa.pages.elements.LinksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage{

    

    public SidePanel(WebDriver driver)   {
        super(driver);
    }


    @FindBy(css = ".show #item-0")
    WebElement login;

    public LoginPage selectLogin(){
        clickWitJShExecutor(login,0,600);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Profile']")
    WebElement profile;
    public ProfilePage selectProfile() {
        clickWitJShExecutor(profile,0,600);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;
    public LinksPage selectLinks() {
        clickWitJShExecutor(links,0,300);
        return new LinksPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;
    public BrokenLinksImagesPage selectBrockenImage() {
        clickWitJShExecutor(brokenLinksImages,0,300);
        return new BrokenLinksImagesPage(driver);
    }
}
