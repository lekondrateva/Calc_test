package ru.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public record CalculatorPage(WebDriver webDriver) {

    public void calculateIt(String xpath, String expression) {
        webDriver
                .findElement(By.xpath(xpath))
                .sendKeys(expression);
    }

    public void checkResult(String xpath, String expectedResult) {
        String result = webDriver
                .findElement(By.xpath(xpath))
                .getText();
        assertEquals(expectedResult, result);
        System.out.println(result);
    }

    public void checkExpressionExist(String xpath, String expression) {
        String expressionHere = webDriver
                .findElement(By.xpath(xpath))
                .getText();
        assertEquals(expression, expressionHere
                .replace(" ", "")
                .replace("×", "*"));
        System.out.println(expressionHere);
    }
}
