package org.ait.demoga.tests;

import org.ait.demoqa.pages.BookStoryPage;
import org.ait.demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookTest(){
        new BookStoryPage(driver)
                .enterBookName("Git")
                .verifyBookName("Git");
    }
}
