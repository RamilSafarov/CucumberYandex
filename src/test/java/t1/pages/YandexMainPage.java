package t1.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class YandexMainPage {
    //локаторы
    private static final SelenideElement marketButton = $x("//div[text()='Маркет']");

    public void goToMarket() {
        marketButton.shouldBe(Condition.enabled).click();
        switchTo().window(1);
    }
}
