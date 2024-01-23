package demoQAWebsite.Tests;

import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class RecursionTest {

    public WebDriver driver;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void parcurgereLista() {
        // Deschidem un browser de Chrome :)
        driver = new ChromeDriver();

        // Facem browserul in modul Maximize - pentru a evita repozitionarea
        // elementelor cu marimea default a ferestrei
        driver.manage().window().maximize();

        // Accesam o pagina Web
        driver.get("https://demoqa.com/");

        // Tema - De intrat succesiv folosind ce am invatat
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");

        // Decalam elementele prin Drag and Drop
        Actions actions = new Actions(driver);
        String listElementsXPath = "//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']";
        List<WebElement> elementsList = driver.findElements(By.xpath(listElementsXPath));
        for (int i = 0; i < elementsList.size() - 1; i++) {
            WebElement currentElement = elementsList.get(i);
            WebElement nextElement = elementsList.get(i + 1);
            System.out.println("Element: " + currentElement.getText());
            actions.clickAndHold(currentElement)
                .moveToElement(nextElement)
                .release()
                .build()
                .perform();
        }

        driver.close();
    }

}
