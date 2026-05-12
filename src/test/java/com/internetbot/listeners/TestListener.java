package com.internetbot.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.internetbot.reports.ExtentManager;
import com.internetbot.utils.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        TEST.set(ExtentManager.getReporter()
                .createTest(result.getMethod().getMethodName())
                .assignCategory(result.getTestClass().getRealClass().getSimpleName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtil.capture(result.getMethod().getMethodName());
        TEST.get().log(Status.FAIL, result.getThrowable());
        if (!screenshotPath.isBlank()) {
            TEST.get().addScreenCaptureFromPath(screenshotPath);
            TEST.get().log(Status.INFO, "Failure screenshot saved at: " + screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TEST.get().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flush();
        TEST.remove();
    }
}
