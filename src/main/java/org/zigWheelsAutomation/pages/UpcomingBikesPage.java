package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class UpcomingBikesPage extends  UpcomingHondaBikesPage{

    @FindBy(xpath = "//a[contains(@data-track-label,'model')]")
    private List<WebElement> bikeNameElements;

    @FindBy(xpath = "//div[contains(@class,'b fnt')]")
    private List<WebElement> bikePriceElements;


    @FindBy(xpath = "//div[contains(@class,'clr-try') and contains(text(),'Expected Launch')]")
    private List<WebElement> expectedLaunchElements;


    public UpcomingBikesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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

    public double parsePriceToLakh(String priceText) {
        try {
            String cleaned = priceText
                    .replaceAll("(?i)rs\\.?", "")   // remove 'Rs' or 'Rs.' (case-insensitive)
                    .replaceAll("(?i)lakh", "")     // remove 'Lakh' (case-insensitive)
                    .replaceAll(",", "")            // remove commas if any
                    .trim();                        // strip leading/trailing spaces
            return Double.parseDouble(cleaned);
        } catch (NumberFormatException e) {
            return -1;
        }
        // Rs 5.0 Lakh
    }

    public List<String> getPricesBelow(double thresholdInLakh) {
        List<String> filtered = new ArrayList<>();
        for (String price : getBikePrices()) {
            double value = parsePriceToLakh(price);
            if (value > 0 && value < thresholdInLakh) {
                filtered.add(price);
            }
        }
        return filtered;
    }

    public Map<String, String> getBikesBelow(double thresholdInLakh) {
        Map<String, String> result = new LinkedHashMap<>();
        List<String> names = getBikeNames();
        List<String> prices = getBikePrices();

        int size = Math.min(names.size(), prices.size());
        for (int i = 0; i < size; i++) {
            double value = parsePriceToLakh(prices.get(i));
            if (value > 0 && value < thresholdInLakh) {
                result.put(names.get(i), prices.get(i));
            }
        }
        return result;
    }

    public List<String> getExpectedLaunchDates() {
        List<String> dates = new ArrayList<>();
        for (WebElement ele : expectedLaunchElements) {
            String text = ele.getText().trim();
            if (!text.isEmpty()) {
                dates.add(text);
            }
        }
        return dates;
    }

    public List<String> getLaunchDatesOnly() {
        List<String> dates = new ArrayList<>();
        for (String fullText : getExpectedLaunchDates()) {
            if (fullText.contains(":")) {
                dates.add(fullText.split(":", 2)[1].trim());
            }
        }
        return dates;
    }

    public Map<String, String> getBikesWithLaunchDates() {
        Map<String, String> result = new LinkedHashMap<>();
        List<String> names = getBikeNames();
        List<String> dates = getExpectedLaunchDates();

        int size = Math.min(names.size(), dates.size());
        for (int i = 0; i < size; i++) {
            result.put(names.get(i), dates.get(i));
        }
        return result;
    }

    public LocalDate parseLaunchDate(String dateText) {
        try {
            String cleaned = dateText.replaceAll("(?i)expected launch\\s*:\\s*", "").trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
            return LocalDate.parse(cleaned, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}