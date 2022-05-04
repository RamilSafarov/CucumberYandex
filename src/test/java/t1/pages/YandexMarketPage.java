package t1.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class YandexMarketPage {
    //Локаторы
    private static final SelenideElement catalogButton = $x("//span[text() ='Каталог']/parent::div/parent::span/parent::button");
    private static final SelenideElement zooButton = $x("//span[text()='Зоотовары']/parent::a");
    private static final SelenideElement goodiesButton = $x("(//a[text()='Лакомства']/parent::div)[1]");
    private static final SelenideElement inputFrom = $x("//input[@name='Цена от']");
    private static final SelenideElement inputTo = $x("//input[@name='Цена до']");
    private static final SelenideElement deliveryButton = $x("//span[text()='Доставка курьером']/parent::div");
    private static final SelenideElement deliveryButton2 = $x("//span[text()='Курьером']/parent::span");
    private static final SelenideElement showallButton = $x("//legend[text()='Производитель']/following-sibling::footer/button[text()='Показать всё']");
    private static final SelenideElement inputManufacturer = $x("//input[@name='Поле поиска']");
    private static final SelenideElement checkboxManufacturer = $x("//input[@name='Производитель Dreamies']/parent::label");
    private static final SelenideElement selectFirst = $x("(//article[@data-zone-name=\"snippet-cell\"])[1]/descendant::a[@data-node-name='title']");
    private static final SelenideElement selectCompare = $x("//span[text()='Сравнить']/parent::div");

    public void getGoodiesForCat() throws InterruptedException {
        //Каталог
        catalogButton.shouldBe(Condition.enabled).click();

        zooButton.shouldBe(Condition.enabled).hover();

        goodiesButton.shouldBe(Condition.enabled).click();

        try {
            deliveryButton.shouldBe(Condition.visible).click();
        }
        catch (NoSuchElementException e){
            deliveryButton2.shouldBe(Condition.visible).click();
        }

        try{
            showallButton.shouldBe(Condition.enabled).click();
            inputManufacturer.shouldBe(Condition.enabled).setValue("Dreamies");
        } catch (NoSuchElementException e){
            inputManufacturer.shouldBe(Condition.enabled).setValue("Dreamies");
        }

        checkboxManufacturer.shouldBe(Condition.enabled).click();

        inputFrom.shouldBe(Condition.enabled).setValue("50");
        inputTo.shouldBe(Condition.enabled).setValue("150");

        TimeUnit.SECONDS.sleep(3);

        selectFirst.shouldBe(Condition.enabled).click();
        switchTo().window(2);

        selectCompare.shouldBe(Condition.enabled).click();
        TimeUnit.SECONDS.sleep(3);
    }
}
