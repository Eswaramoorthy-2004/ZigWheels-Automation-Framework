package org.zigWheelsAutomation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    Properties prop;
    public  PropertyReader() throws IOException{
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(fis);
    }
    public String getPageTitle() {
        return prop.getProperty("pageTitle");
    }
    public String getPageURL() {
        return prop.getProperty("page.url");
    }
    public String getUpcomingBikesURL() {
        return prop.getProperty("upcomingBikes.url");
    }
    public String getHondaBikesURL() {
        return prop.getProperty("hondaBikes.url");
    }
    public String getUpcomingBikesPageTitle(){
        return  prop.getProperty("upcomingBikesPageTitle");
    }
    public String getUpcomingHondaPageTitle(){
        return prop.getProperty("upcomingHondaPageTitle");
    }

}
