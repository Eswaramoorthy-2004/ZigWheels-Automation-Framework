package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UpcomingBikesPage {

    private WebDriver driver;

    // ---------- WebElements ----------
    @FindBy(xpath = "//a[contains(@data-track-label,'model')]")
    private List<WebElement> bikeNameElements;

    @FindBy(xpath = "//div[contains(@class,'b fnt')]")
    private List<WebElement> bikePriceElements;

    // ---------- Constructor ----------
    public UpcomingBikesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ---------- Action Methods ----------

    /** Extracts non-empty bike names from the upcoming bikes listing. */
    public List<String> getBikeNames() {
        List<String> names = new ArrayList<>();
        for (WebElement ele : bikeNameElements) {
            String name = ele.getText().trim();
            if (!name.isEmpty()) {
                names.add(name);
            }
        }
        return names;
    }

    /** Extracts only valid 'Rs. X Lakh' style prices, skipping blanks & junk. */
    public List<String> getBikePrices() {
        List<String> prices = new ArrayList<>();
        for (WebElement ele : bikePriceElements) {
            String price = ele.getText().trim();
            if (!price.isEmpty() && price.toLowerCase().startsWith("rs")) {
                prices.add(price);
            }
        }
        return prices;
    }

    public int getBikeCount() {
        return getBikeNames().size();
    }

    public int getPriceCount() {
        return getBikePrices().size();
    }
}