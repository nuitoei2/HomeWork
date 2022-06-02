package pages;


import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

        public class DashboardPage extends BasePage {
        protected WebDriver driver;

        public DashboardPage (WebDriver driver){
            super(driver);
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//nav//a/u[text()='Sign out']")
        public WebElement signOutBtn;

        @FindBy(xpath = "//*[text()='Manage Access']")
        public List<WebElement> manageAccessBtns;
    }

