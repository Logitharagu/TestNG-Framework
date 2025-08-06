package Wrapper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * why we use EXTENTTEST test?
 *   This class used for single execution of particular methods and created only one report step in methods
 * Why we use test and node EXTENTTEST used here?
 *   In program we used DataProvider methods that means one particular methods execute many time
 *  based on DataProvide enter value . when we need report for each value are passed throw DataProvider.  
 */

public abstract class HTMLreport {
	public static ExtentSparkReporter Ospark;
	public static ExtentReports Oreport;
	public ExtentTest test,node;
	public String authors,category;
	//public String filePath="./Report/SalseForce.html";
	private static String pattern = "dd-MMM-yyyy HH-mm-ss";
	public static String folderName = "";
	
	
	public static String createFolder(String folderName) {
		String date = new SimpleDateFormat(pattern).format(new Date());
		folderName = folderName+"/" + date;

		File folder = new File("./" + folderName);
		if (!folder.exists()) {
			folder.mkdir();
		}
		return folderName;
	}
	
	
	public void startReport() {
		folderName=createFolder("report");
		Ospark=new ExtentSparkReporter("./"+folderName+"/SalesForceReport.html");
		Oreport=new ExtentReports();
		Oreport.attachReporter(Ospark);
	}
	
	public void endReport() {
		Oreport.flush();
	}
	
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		test=Oreport.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);
		return test;
	}
	
	public ExtentTest startTestCase(String nodes) {
		node=test.createNode(nodes);
		return node;
	}
	public void reportStep(String description, String status) {

		if (status.equalsIgnoreCase("pass")) {
			//node.pass(description);
			node.pass(description,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		} else if(status.equalsIgnoreCase("fail")){
			node.fail(description,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		}else {
			node.info(description);
		}
		
	}
	public abstract String takeScreenShot();

}
