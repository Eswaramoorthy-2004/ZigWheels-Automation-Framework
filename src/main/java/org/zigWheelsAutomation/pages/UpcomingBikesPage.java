package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UpcomingBikesPage extends  UpcomingHondaBikesPage{

    // ---------- WebElements ----------
    @FindBy(xpath = "//a[contains(@data-track-label,'model')]")
    private List<WebElement> bikeNameElements;

    @FindBy(xpath = "//div[contains(@class,'b fnt')]")
    private List<WebElement> bikePriceElements;

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
    }

    /**
     * Returns only the price strings that are strictly below the given threshold (in Lakh).
     *
     * @param thresholdInLakh the upper limit in Lakh (exclusive), e.g., 5.0 for < Rs. 5 Lakh
     * @return list of price strings like ["Rs. 2.15 Lakh", "Rs. 3.80 Lakh", ...]
     */
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

    /**
     * Returns a map of Bike Name → Price for all bikes priced below the given threshold.
     * Uses LinkedHashMap to preserve the display order from the website.
     *
     * @param thresholdInLakh the upper limit in Lakh (exclusive), e.g., 5.0 for < Rs. 5 Lakh
     * @return ordered map like {"Yamaha YZF-R2" → "Rs. 2.15 Lakh", ...}
     */
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
}