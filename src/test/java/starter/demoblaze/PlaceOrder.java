package starter.demoblaze;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class PlaceOrder extends PageComponent {
    public String getOrder() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#orderModal > div > div")));
        return $("#orderModal > div > div").getText();

    }
    public String successfulOrder() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/h2")));
        return $("/html/body/div[10]/h2").getText();
    }

}
