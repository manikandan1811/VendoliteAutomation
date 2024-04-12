package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepDefinitions",
		tags = "@VendoLite014",
		monochrome = true,
		plugin = {"pretty","rerun:rerun.txt", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/html", "json:target/cucumber.json"}
)

public class RunTest extends AbstractTestNGCucumberTests {

}

