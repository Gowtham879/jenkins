package Flight_pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;

import SeleniumCommands.AllCommands;

public class FlightDeparture extends AllCommands {
	public static String getCurrentFormattedTime(String dateFormatString) {
		DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		TimeZone etTimeZone = TimeZone.getTimeZone("GMT-5:00");
		dateFormat.setTimeZone(etTimeZone);
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
		}
	public static String getFutureFormatedTime(int daysToBeAdded, String dateFormatString) {
			DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
			TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");
			dateFormat.setTimeZone(etTimeZone);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, daysToBeAdded);
			return dateFormat.format(calendar.getTime());
			}
public void futureDate() {
	driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
	this.delayScript(3);
    String futureDateTime = getFutureFormatedTime(10,"d-MMM-yyyy");
	System.out.println(futureDateTime);
	String futureDay=futureDateTime.split("-")[0].trim();
	String futureMonth = futureDateTime.split("-")[1].trim();
	String futureYear = futureDateTime.split("-")[2].trim();
	String futuremonth=futureMonth.toUpperCase();
	System.out.println(futuremonth);
	selectedDate(futureDay, futuremonth, futureYear,futureMonth);
}
public void currentDate() {
	driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
	this.delayScript(3);
	String currentDateTime = getCurrentFormattedTime("d-MMM-yyyy");
	System.out.println(currentDateTime);
	String curDay=currentDateTime.split("-")[0].trim();
	String curMonth = currentDateTime.split("-")[1].trim();
	String curYear = currentDateTime.split("-")[2].trim();
	String curmonth=curMonth.toUpperCase();
	selectedDate(curDay, curmonth, curYear,curMonth);
}
public void selectedDate(String curDay,String curmonth,String curYear, String curMonth)  {
    String monthYear = driver.findElement(By.xpath("//div[@class='month2']")).getText();
	String month = monthYear.split(" ")[0].trim();
	String year = monthYear.split(" ")[1].trim();
	while(!(curmonth.equals(month) && curYear.equals(year))){
		driver.findElement(By.xpath("//div[@class='month3']//img[@alt='Arrow']")).click();
	     monthYear = driver.findElement(By.xpath("//div[@class='month2']")).getText();
		 month = monthYear.split(" ")[0].trim();
		 year = monthYear.split(" ")[1].trim();
		}
	driver.findElement(By.xpath("//div[text()='"+curMonth+" "+curYear+"']/../following-sibling::div//li[text()='"+curDay+"']")).click();
}

}
