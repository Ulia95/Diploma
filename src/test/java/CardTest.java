import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static com.codeborne.selenide.Selenide.open;

public class CardTest {

    @BeforeAll

    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @BeforeEach
    void shouldLogin() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }
    // Заполнить форму действительными данными
    @Test
    public void fillOutTheFormWithAValidCourt(){
        CardPage.payToButton();
        var cardInfo = DataHelper.validFields();
        CardPage.completedForm(cardInfo);
        CardPage.successfulOperation();
        //МНЕ НЕ ПОНЯТНО ПОЧЕМУ Я ТУТ НЕ МОГУ ВЫЗВАТЬ МЕТОД "errorOperation" ИЗ КЛАССА "CardPage"
    }
    // покупка с незарегистрированной картой
    @Test
    public void purchaseWithAnUnregisteredCard(){
        CardPage.payToButton();
        var cardInfo = DataHelper.unregisteredСard();
        CardPage.completedForm(cardInfo);
    }
}