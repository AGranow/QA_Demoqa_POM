package org.ait.demoga.tests.elements;

import org.ait.demoga.tests.TestBase;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.elements.BrokenLinksImagesPage;
import org.ait.demoqa.pages.elements.LinksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTest extends TestBase {


    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
    }

    @Test
    public void getAllLinksTest(){
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).getAllLinks();
    }

    @Test
    public void checkBrokenLinksTest(){
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).checkBrokenLinks();
    }

    @Test
    public void checkBrockenImages(){
        new SidePanel(driver).selectBrockenImage();
        new BrokenLinksImagesPage(driver).checkBrokenImages();
    }
}
