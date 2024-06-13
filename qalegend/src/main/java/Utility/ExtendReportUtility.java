package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();
	public synchronized static ExtentReports createExtentReports()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");// location for report
		reporter.config().setReportName("QALegend Project");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "sree");
		return extentReports;
    }
}
