package com.apple.mac.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.apple.mac.managers.FileReaderManager;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict=true
		,features = "feature"
		,glue = "com.apple.mac.stepdefinations"
		,plugin = { "com.cucumber.listener.ExtentCucumberFormatter:reports/report.html"}
		)
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		System.out.println("After Class");
	}
}
