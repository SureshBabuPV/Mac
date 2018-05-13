package com.apple.mac.stepdefinations;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.apple.mac.context.TestContext;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {

	    Reporter.assignAuthor("Apple Website Testing");
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			ExtentProperties extentProperties = ExtentProperties.INSTANCE;
			String strReportPath= extentProperties.getReportPath();
			String strScreenshots= (String) strReportPath.subSequence(0, strReportPath.lastIndexOf("/"));
			//String userdir= System.getProperty("user.dir");
			//System.setProperty("user.dir",userdir+"/"+ strReportPath.subSequence(0, strReportPath.lastIndexOf("/")));
			//System.setProperty("user.dir",userdir);
			//String screenshotName = scenario.getName().replaceAll(" ", "_");
			Date d=new Date();
			String screenshotName=d.toString().replace(":", "_").replace(" ", "_")+".png";
			try {
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/"+ strScreenshots+ "/"+ screenshotName );
				System.out.println(destinationPath);
				Files.copy(sourcePath, destinationPath);   
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
				System.out.println("In Catch" + e.getStackTrace());
			} 
		}
	}
	
	
	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}

}
