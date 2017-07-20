package lib;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int minretrycount = 0;
	int maxretrycount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		
		
		if(minretrycount<maxretrycount)
		{
			System.out.println("Following test is failing===="+result.getName());
			
			minretrycount++;
			
			return true;
			
		}
		
		return false;
	}
	

}
