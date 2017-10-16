package org.KsushaS;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test was started");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test was executed successfully");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test was failed");
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }
}
