package org.zigWheelsAutomation.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportPath = "reports/ExtentReports/ExtentReport_" + timestamp + ".html";
        File reportDir = new File("reports/ExtentReports");
        if (!reportDir.exists()) reportDir.mkdirs();
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("ZigWheels Automation Report");
        spark.config().setReportName("ZigWheels Test Execution");
        spark.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Project", "ZigWheels Automation Framework");
        extent.setSystemInfo("Tester", "QA Team");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }
}