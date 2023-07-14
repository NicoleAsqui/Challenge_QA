package starter.demoblaze;


import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class PlaceOrderActions extends UIInteractions {
    @Step("Add Detail")
    public void addDetail(String classes, String parameter)  {
        String selector = String.format("#%s", classes);
        $(selector).type(parameter);
    }
    @Step("Purchase Order")

    public void purchaseOrder() {
        $("#orderModal > div > div > div.modal-footer > button.btn.btn-primary").click();

    }
}
