package ui.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class TestListener extends TestListenerAdapter {
    private Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        Properties properties = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("target/allure-results/environment.properties");
        } catch (FileNotFoundException | NullPointerException exception) {
        }
        try {
            properties.store(output, "File 'environment.properties' created");
            output.close();
        } catch (IOException | NullPointerException exception) {
        }
        logger.info("-----------------------TEST STARTED " + result.getTestClass().getName() +
                " TEST:" + result.getName() + "---------------------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("FAILED: " + result.getTestClass().getName() + " TEST:" + result.getName());
        logger.error("REASON: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getTestClass()
                .getName() + " TEST:" + result.getName() + " " +
                Arrays.toString(
                        result.getParameters()) + "...........................................SUCCESS");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("SKIPPED: " + result.getTestClass().getName() + " TEST:" + result.getName() +
                " REASON: " + result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext result) {
        logger.info("TEST FINISHED");
    }
}