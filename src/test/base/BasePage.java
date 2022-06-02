package base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;
    public class BasePage {


        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void sleep(Long millSeconds) {
            try {
                Thread.sleep(millSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void click(WebElement element) {
            moveIntoView(element);
            highlightElement(element);
            waitForElementClickability(element);
            element.click();
        }

        public void sendKeys(WebElement element, String inputText) {
            moveIntoView(element);
            highlightElement(element);
            waitForElementVisibility(element);
            element.sendKeys(inputText);
        }

        public String getText(WebElement element) {
            moveIntoView(element);
            highlightElement(element);
            waitForElementVisibility(element);
            return element.getText();
        }

        public void waitForElementClickability(WebElement element) {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        public void waitForElementVisibility(WebElement element) {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
        }

        public void moveIntoView(WebElement element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }

        public void highlightElement(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            for (int i = 0; i < 4; i++) {
                try {
                    if (i % 2 == 0) {
                        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black;" +
                                "border: 3px solid red; background: yellow");
                    } else {
                        sleep(50l);
                        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }


        public static void switchToNextWindow(WebDriver driver) throws InterruptedException {

            String mainWindowID = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();


            for (String each : allWindows) {
                Thread.sleep(2000);
                driver.switchTo().window(each);
                if (driver.getTitle().contains("YouTube")) {
                    Thread.sleep(2000);
                    System.out.println(driver.getTitle());
                    driver.close();
                } else if (driver.getTitle().contains("Twitter")) {
                    Thread.sleep(2000);
                    System.out.println(driver.getTitle());
                    driver.close();
                } else if (driver.getTitle().contains("Instagram")) {
                    Thread.sleep(2000);
                    driver.close();
                } else if (driver.getTitle().contains("Facebook")) {
                    Thread.sleep(2000);
                    System.out.println(driver.getTitle());
                    driver.close();
                }
            }

            driver.switchTo().window(mainWindowID);
        }

    }

