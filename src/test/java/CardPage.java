import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CardPage {

    private static SelenideElement buyButton = $x("//span[text() = 'Купить']");
    private static SelenideElement buyOnCreditButton = $x("//span[text() = 'Купить в кредит']");
    private static SelenideElement cardNumberField = $x("//span[text() = 'Номер карты']/..//input");
    private static SelenideElement fieldMonth = $x("//span[text() = 'Месяц']/..//input");
    private static SelenideElement fieldOwner = $x("//span[text() = 'Владелец']/..//input");
    private static SelenideElement fieldYear = $x("//span[text() = 'Год']/..//input");
    private static SelenideElement fieldCVC = $x("//span[text() = 'CVC/CVV']/..//input");
    private static SelenideElement continueButton = $x("//span[text() = 'Продолжить']/../..");
    private static SelenideElement notificationSuccessful = $x("//div[text()= 'Успешно!']");

    private static SelenideElement error = $x("//div[text()= 'Ошибка']");

    public static void payToButton(){ //опратить на кнопку
        buyButton.click();
    }
    public static void buyOnCreditButton(){ //кнопка оплатить в кредит
        buyOnCreditButton.click();
    }
    public static void completedForm(DataHelper.cardInfo info){ //заполненная анкета
        cardNumberField.setValue(info.getCardNumber());
        fieldMonth.setValue(info.getMonth());
        fieldOwner.setValue(info.getOwner());
        fieldYear.setValue(info.getYear());
        fieldCVC.setValue(info.getCvc());
        continueButton.click();
    }
    public static void successfulOperation(){ //успешная операция
        notificationSuccessful.should(Condition.visible, Duration.ofSeconds(20));
    }

    private static void errorOperation(){ //операция с ошибкой
       error.should(Condition.visible, Duration.ofSeconds(20));

}
}
