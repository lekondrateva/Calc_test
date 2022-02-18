package ru.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tests {
    public static final WebDriver webDriver;
    public static final GoogleSearchPage googleSearchPage;
    public static final CalculatorPage calcPage;

    public static final String URL = "http://google.com";
    private static final String SEARCH_FIELD_XPATH = "//input[@title='Поиск']";
    private static final String searchBy = "Калькулятор";
    private static final String CALC_INPUT_FIELD_XPATH = "//div[@class='jlkklc']";
    private static final String EXPECTED_RESULT_XPATH = "//span[@id='cwos']";
    private static final String EXPRESSION_XPATH = "//span[@class='vUGUtc']";
    private static final String expression = "1*2-3+1=";
    private static final String expectedResult = "0";

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LenOK\\IdeaProjects\\22\\09\\Calc_test\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();

        googleSearchPage = new GoogleSearchPage(webDriver);
        calcPage = new CalculatorPage(webDriver);
    }

    @Before
    public void goUrl() {
        webDriver.get(URL);
    }

    @After
    public void shutDown() {
        webDriver.quit();
    }

    @Test
    @DisplayName("Вычислить значение выражения expression, результат expectedResult")
    public void calculateTheExpression() {
        googleSearchPage.searchByGoogle(SEARCH_FIELD_XPATH, searchBy);
        calcPage.calculateIt(CALC_INPUT_FIELD_XPATH, expression);
        calcPage.checkResult(EXPECTED_RESULT_XPATH, expectedResult);
        calcPage.checkExpressionExist(EXPRESSION_XPATH,expression);
    }
}
