package Academy;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resource.Base;
import resource.Log;


public class TestContext implements ITestListener{
Base b = new Base();
	public void onTestSuccess(ITestResult result) {
		Log.info("\n\nPASSED-->" +result.getMethod().getMethodName()+"\n\n");
		
	}
	

	public void onTestStart(ITestResult result) {
		
		Log.info("\n\nSTARTING-->" +result.getMethod().getMethodName()+"\n\n");
	}
	

	public void onTestSkipped(ITestResult result) {
		Log.info("\n\nSKIPPED-->" +result.getMethod().getMethodName()+"\n\n");
	}
	

	public void onTestFailure(ITestResult result) {
		//Log.info("\n\nFAIL-->" +result.getMethod().getMethodName()+"\n\n");	
		
		try {
			System.out.println("faild screnshot listner");
			b.GetScreenShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	

	public void onStart(ITestContext context) {
		Log.info("Output Directory is --> "+context.getOutputDirectory());
	}
	

	public void onFinish(ITestContext context) {
		Log.info("Failed tests : \n "+context.getFailedTests());
		
	}
	
	public String setaTestClass(ITestResult result) {
		return result.getMethod().getTestClass().getName();
	}


	
	
	
	
	
}
