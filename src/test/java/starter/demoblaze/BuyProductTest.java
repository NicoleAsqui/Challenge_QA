package starter.demoblaze;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SerenityJUnit5Extension.class)
public class BuyProductTest {
    @Managed(driver = "chrome", options = "headless")
    WebDriver driver;
    NavigateActions navigate;
    AddProductsActions products;
    Search search;
    PlaceOrder order;
    PlaceOrderActions orderActions;
    @Test
    void shouldOrderWithTwoProducts() {
        String successfulMessageExpected = "Thank you for your purchase!";
        int totalofProductsExpected = addProductAndCloseAlert(2);
        navigate.toTheDemoBlazeCartPage();
        search.getTotal();
        products.placeOrder();
        order.getOrder();
        orderActions.addDetail("name","Nicole Asqui Manzaba");
        orderActions.addDetail("country","Ecuador");
        orderActions.addDetail("city","Guayaquil");
        orderActions.addDetail("card","Mastercard");
        orderActions.addDetail("month","Junio");
        orderActions.addDetail("year","2003");
        orderActions.purchaseOrder();

        assertThat(search.getTotal()).isEqualTo(String.valueOf(totalofProductsExpected));
        assertThat(order.successfulOrder()).isEqualTo(successfulMessageExpected);
    }
    public int addProductAndCloseAlert(int numberOfProducts) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        int totalofProducts = 0;
        for(int i = 1; i <= numberOfProducts; i ++){
            navigate.toTheDemoBlazeSearchPage();
            products.addItem(i);
            products.closeAlert(wait);
            totalofProducts += Utils.extractNumber(search.getPrice());
        }
        return totalofProducts;
    }


}