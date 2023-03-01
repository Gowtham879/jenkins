package Flight_pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;

import SeleniumCommands.AllCommands;

public class FlightReturn extends AllCommands {
	public static String getFutureFormatedTime(int daysToBeAdded, String dateFormatString) {
		DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");
		dateFormat.setTimeZone(etTimeZone);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, daysToBeAdded);
		return dateFormat.format(calendar.getTime());
		}
public void returnDate() {
driver.findElement(By.xpath("//p[@id='rtag']")).click();
this.delayScript(3);
String futureDateTime = getFutureFormatedTime(11,"d-MMM-yyyy");
System.out.println(futureDateTime);
String futureDay=futureDateTime.split("-")[0].trim();
String futureMonth = futureDateTime.split("-")[1].trim();
String futureYear = futureDateTime.split("-")[2].trim();
String futuremonth=futureMonth.toUpperCase();
selectedDate(futureDay, futuremonth, futureYear,futureMonth);
}

public void selectedDate(String futureDay,String futuremonth,String futureYear, String futureMonth)  {
    String monthYear = driver.findElement(By.xpath("//div[@class='month2']")).getText();
	String month = monthYear.split(" ")[0].trim();
	String year = monthYear.split(" ")[1].trim();
	while(!(futuremonth.equals(month) && futureYear.equals(year))){
		driver.findElement(By.xpath("//div[@class='month3']//img[@alt='Arrow']")).click();
	     monthYear = driver.findElement(By.xpath("//div[@class='month2']")).getText();
		 month = monthYear.split(" ")[0].trim();
		 year = monthYear.split(" ")[1].trim();
		}
	driver.findElement(By.xpath("//div[text()='"+futureMonth+" "+futureYear+"']/../following-sibling::div//li[text()='"+futureDay+"']")).click();
	//driver.findElement(By.xpath("//button[text()=' Search']")).click();
}

}
