package org.ait.demoga.tests.bookStore;

import org.ait.demoga.tests.TestBase;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.bookStore.LoginPage;
import org.ait.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        // TDD
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }


    @Test
    public void loginPositiveTest(){
        new LoginPage(driver)
                .login("Bobi", "1q2w3e4r5t!")
                .verifyUserName("Bobi");
    }
}
