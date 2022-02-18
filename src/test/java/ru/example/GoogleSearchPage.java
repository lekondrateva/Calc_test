package ru.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public record GoogleSearchPage(WebDriver webDriver) {

    public void searchByGoogle(String url, String xpath, String text) {
        webDriver
                .get(url);
        webDriver
                .findElement(By.xpath(xpath))
                .sendKeys(text, Keys.ENTER);
    }
}
