package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 2,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
        excludeCoverageTags = {"" },
        includeCoverageTags = {"" },
        outputFolder = "target/cucumber-reports/extended-report")
@CucumberOptions(
		features="src//main//resources//features",

		glue= {"stepdefs"},
		dryRun=false,
		strict=false,
		monochrome=true,
		plugin= {"pretty",
		//"usage:target\\cucumber-reports\\"
				//"html:target\\html-reports\\"
				//"json:target\\json-reports\\"
				//"junit:target//json-reports//cucumber.xml"
				"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport1.html"
			}
)


public class HotelBookingRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("Uesr Name", System.getProperty("user.name") );
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone") );
		Reporter.setSystemInfo("Application Name", System.getProperty("user.applicationname") );
	
	}
}
