package registration_php;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenshots_failedcases {

	public static void take_screenshot(WebDriver driver, String screen_shot_path) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(screen_shot_path));
		

	}

}
