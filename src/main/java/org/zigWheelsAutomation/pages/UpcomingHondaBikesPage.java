package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UpcomingHondaBikesPage extends HomePage{

    public UpcomingHondaBikesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(@title,'upcoming Honda bikes')]")
    WebElement hondaButton;

    @FindBy(xpath = "//h2[contains(@class,'mt')]")
    WebElement hondaPageText;

    @FindBy(xpath = "//img[contains(@class,'lazy')]")
    List<WebElement> bikesImages;

    @FindBy(xpath = "//a[contains(@data-track-label,'model')]")
    private List<WebElement> bikeNameElements;

    public List<WebElement> getBikeNameElements() {
        return bikeNameElements;
    }

    @FindBy(xpath = "//div[contains(@class,'b fnt')]")
    private List<WebElement> bikePriceElements;

    public List<WebElement> getBikePriceElements() {
        return bikePriceElements;
    }

    @FindBy(xpath = "//div[contains(@class,'clr-try') and contains(text(),'Expected Launch')]")
    private List<WebElement> expectedLaunchElements;

    public List<WebElement> getExpectedLaunchElements() {
        return expectedLaunchElements;
    }

    public void clickHondaButton(){
        javaScriptUtil.scrollIntoView(hondaButton);
        javaScriptUtil.clickElement(hondaButton);
    }

    public WebElement getHondaPageText(){
        return hondaPageText;
    }

    public boolean isBikeImageDisplayed(){
        for(WebElement bikes : bikesImages){
            if(!bikes.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isBikeNameVisible(){
        for (WebElement bikeName : bikeNameElements){
            if(!bikeName.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public boolean isBikePriceVisible(){
        for (WebElement bikePrice : bikePriceElements){
            if(!bikePrice.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public boolean checkHondaBikesAreDisplayed(){
        boolean flag = false;
        for (WebElement ele : getBikeNameElements()) {
            flag = ele.getText().contains("Honda");
        }
        return flag;
    }

    public List<String> getBikeNames() {
        List<String> names = new ArrayList<>();
        for (WebElement ele : getBikeNameElements()) {
            String name = ele.getText().trim();
            if (!name.isEmpty()) {
                names.add(name);
            }
        }
        return names;
    }

    public List<String> getBikePrices() {
        List<String> prices = new ArrayList<>();
        for (WebElement ele : getBikePriceElements()) {
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
        for (WebElement ele : getExpectedLaunchElements()) {
            String text = ele.getText().trim();
            if (!text.isEmpty()) {
                dates.add(text);
            }
        }
        return dates;
    }

}
