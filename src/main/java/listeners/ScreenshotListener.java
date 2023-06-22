package listeners;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utils.MyScreenRecorder;
import utils.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        Test test = method.getAnnotation(Test.class);
        String testName = test.testName();
        Reporter.log("<h3 style='text-align: center;'>" + testName + "</h3>");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

//        try {
//            MyScreenRecorder.startRecording(result);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }


}
