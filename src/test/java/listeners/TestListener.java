package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.zigWheelsAutomation.utilities.ExtentManager;

public class TestListener implements ITestListener {

    private static final Logger log = LogManager.getLogger(TestListener.class);
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        log.info("Test Suite Started: {}", context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(testName);
        extentTest.set(test);

        test.info("Test Started: " + testName);
        log.info("Test Started: {}", testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed: " + result.getMethod().getMethodName());
        log.info("Test Passed: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTest.get();
        test.fail("Test Failed: " + result.getMethod().getMethodName());
        test.fail(result.getThrowable());
        log.error("Test Failed: {}", result.getMethod().getMethodName(), result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped: " + result.getMethod().getMethodName());
        log.warn("Test Skipped: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        log.info("Test Suite Finished: {}", context.getName());
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }
}