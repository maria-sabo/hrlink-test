package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class MyExtentTestManager {
    static ExtentReports extent = ExtentManager.getReporter();


    public static ExtentTest startTest(String testName, String description) {
        return extent.startTest(testName, description);
    }

    public static void endTest(ExtentTest test) {
        extent.endTest(test);
        extent.flush();
    }
}