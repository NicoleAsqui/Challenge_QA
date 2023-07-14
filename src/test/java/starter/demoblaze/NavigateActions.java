package starter.demoblaze;
import net.thucydides.core.annotations.Step;

import net.serenitybdd.core.steps.UIInteractions;
public class NavigateActions extends UIInteractions{
    @Step("Navigate to the home page")
    public void toTheDemoBlazeSearchPage() {
        openUrl("https://www.demoblaze.com/");
    }

    @Step("Navigate to the Cart page")
    public void toTheDemoBlazeCartPage() {
        openUrl("https://www.demoblaze.com/cart.html");
    }
}
