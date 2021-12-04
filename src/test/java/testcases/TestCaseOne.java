package testcases;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import testbase.TestBase;

public class TestCaseOne extends TestBase {
	
	@Test
	public void testOneGrid() throws MalformedURLException {
		
		launchBrowser("Chrome");
		
		driver.get("https://money.rediff.com/index.html");
	}

}
