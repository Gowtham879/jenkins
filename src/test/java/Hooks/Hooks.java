package Hooks;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import SeleniumCommands.AllCommands;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks extends AllCommands{
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
	    byte[] scrennshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("ScreenShot", new ByteArrayInputStream(scrennshot));
//		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
//		byte[] file=FileUtils.readFileToByteArray(source);
//		scenario.attach(file, "image/png", "ScreenShot");
		}
	}

}
