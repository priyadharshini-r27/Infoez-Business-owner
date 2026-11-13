package runner;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	import org.testng.annotations.DataProvider;

	@CucumberOptions(features = { "src\\test\\resources\\features" }, glue = { "stepdefinitions", "hooks" },
                    tags = "@Notifications",
	                plugin = {"pretty", "html:target/cucumber-reports/report.html" })
	public class TestRunner extends AbstractTestNGCucumberTests {
		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}


