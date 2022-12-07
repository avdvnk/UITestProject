package core;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

/**
 * Listener class for logging and additional actions during test running
 */
@Slf4j
public class TestDataListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test finished successfully: " + iTestResult.getMethod().getDescription() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test failed: " + iTestResult.getMethod().getDescription() + "\n");
        attachScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test skipped: " + iTestResult.getMethod().getDescription() + "\n");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Running test: " + result.getMethod().getDescription() + "\n");
    }

    /**
     * Method attaches screenshot to test case in Allure report
     * @return Screenshot in byte array
     */
    @Attachment(type = "image/png")
    private byte[] attachScreenshot() {
        try {
            File screenshot = Screenshots.getLastScreenshot();
            return (screenshot == null) ? null : Files.toByteArray(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}