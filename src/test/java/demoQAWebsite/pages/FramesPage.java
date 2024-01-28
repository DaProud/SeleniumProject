package demoQAWebsite.pages;

import demoQAWebsite.HelperMethods.ElementsMethods;
import demoQAWebsite.HelperMethods.FramesMethods;
import demoQAWebsite.HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FramesPage {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptHelpers javascriptHelpers;
    FramesMethods framesMethods;
    @FindBy(id = "frame1")
    WebElement frame1Element;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingFromFrame1Element;
    @FindBy(id = "frame2")
    WebElement frame2Element;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingFromFrame2Element;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        this.framesMethods = new FramesMethods(driver);
        PageFactory.initElements(driver, this);
    }

    public void interactWithFrame1() {
        // Frame 1:
        javascriptHelpers.scrollDown(400);
        framesMethods.switchToFrame(frame1Element);
        Assert.assertEquals(sampleHeadingFromFrame1Element.getText(), "This is a sample page");
    }

    public void interactWithFrame2() {
        // Frame 2:
        framesMethods.switchToFrame(frame2Element);
        Assert.assertEquals(sampleHeadingFromFrame2Element.getText(), "This is a sample page");
    }
}
