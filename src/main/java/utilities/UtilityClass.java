package utilities;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import core.Base;

public class UtilityClass extends Base{

	// in this class we write our reusable methods.
	// any methods we will use more than once we will store them here in
	// static methods.

	/**
	 * This method returns date and time as a string
	 * 
	 * @return
	 */
	public static String screenShotName() {

		Date date = new Date();
		String screenShot = date.toString().replace(":", "_").replace(" ", "_");
		return screenShot;

	}

	public static void takeScreenShot() {

		String location = System.getProperty("user.dir") + "\\output\\screenshots\\";
		String screenShotFileName = screenShotName() + ".png";

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File(location + screenShotFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in execution");
		}

	}

	// how to select calendar date using JS Executor

	public static void selectCalendarDateWithJS(String date, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);

	}

	public static boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed())
			return true;
		else
			return false;

	}
}
