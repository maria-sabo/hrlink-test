package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import org.example.ConfProperties;

public class ExtentManager {

    public synchronized static ExtentReports getReporter() {
        return new ExtentReports(ConfProperties.getProperty("reportFilePath"), true);
    }
}