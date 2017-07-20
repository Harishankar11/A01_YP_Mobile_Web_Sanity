package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;


public class Rerunfailcase {

	//@Test
	public void reruntestcase() {
		
		TestNG test = new TestNG();
		
		List<String> list = new ArrayList<>();
		
		list.add("D:\\Workplace\\A02_YP_Mobile_Web_Revamp\\test-output\\Suite\\testng-failed.xml");
		
		test.setTestSuites(list);
		
		test.run();
		

	}

}
