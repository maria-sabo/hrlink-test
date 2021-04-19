package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
//            String workingDir = System.getProperty("user.dir");
//            if (System.getProperty("os.name").toLowerCase().contains("win")) {
//                extent = new ExtentReports("/home/maria/IdeaProjects/hrlink-test/log.html", true);
            extent = new ExtentReports("/home/maria/IdeaProjects/hrlink-test/log2.html", true);
        }

        return extent;
    }
}