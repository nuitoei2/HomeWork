import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class weatherTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void localSetUp(){

        homePage = new HomePage(getDriver());
    }

    @Test(testName = "10 Day")
    public void test7(){

        //Click 10Day
        getDriver().findElement(By.xpath("//span[text()='10 Day']")).click();

    }
}
