package com.apple.mac.runner;

import java.io.File;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.apple.mac.managers.FileReaderManager;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict=true
		,features = "feature"
		,glue = "com.apple.mac.stepdefinations"
		,plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"}
		)
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
	@BeforeClass
	public static void setup() {
		Date d=new Date();
		String folderName=d.toString().replace(":", "_").replace(" ", "_");
		String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("reports/"+ folderName +"/" + fileName);
	    
	}
}
