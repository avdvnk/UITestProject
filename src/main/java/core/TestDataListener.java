package core;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

@Slf4j
public class TestDataListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Тест завершился успешно: " + iTestResult.getMethod().getDescription() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Тест завершился провалом: " + iTestResult.getMethod().getDescription() + "\n");
        attachScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Тест пропущен: " + iTestResult.getMethod().getDescription() + "\n");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Выполняется тест: " + result.getMethod().getDescription() + "\n");
    }

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