package starter.demoblaze;
import net.serenitybdd.core.pages.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Search extends PageComponent {
    public String getPrice() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#tbodyid > h3")));
        return $("#tbodyid > h3").getText();

    }
    public String getTotal() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#totalp")));
        return $("#totalp").getText();

    }
}