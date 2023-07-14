package starter.demoblaze;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;

public class AddProductsActions extends UIInteractions {
    @Step("Click on Item Product")

    public void addItem(int itemNumber) {
        String selector = String.format("#tbodyid > div:nth-child(%d) > div > a", itemNumber);
        $(selector).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid > div.row > div > a")));
        $("#tbodyid > div.row > div > a").click();

    }
    @Step("Place Order")

    public void placeOrder() {
        $("#page-wrapper > div > div.col-lg-1 > button").click();
    }
    public void closeAlert(WebDriverWait wait) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }
}