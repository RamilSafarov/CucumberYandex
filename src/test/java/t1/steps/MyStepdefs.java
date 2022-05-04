package t1.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import t1.pages.YandexMainPage;
import t1.pages.YandexMarketPage;

public class MyStepdefs {
    @Дано("Перейти на страницу Маркет")
    public void firstScenarioTest() throws InterruptedException {
        YandexMainPage yandexMainPage = new YandexMainPage();
        yandexMainPage.goToMarket();

        YandexMarketPage yandexMarketPage = new YandexMarketPage();
        yandexMarketPage.getGoodiesForCat();
    }

}
