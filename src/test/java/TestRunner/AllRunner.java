package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/feature/mainScenario.feature",
		glue="StepsDefination",
		tags="@tag3",
		monochrome=true,
	    plugin={"pretty","io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
		)
public class AllRunner extends AbstractTestNGCucumberTests{
	

}
