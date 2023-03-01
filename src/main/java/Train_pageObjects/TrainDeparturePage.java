package Train_pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;

import SeleniumCommands.AllCommands;

public class TrainDeparturePage extends AllCommands{
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
	driver.findElement(By.xpath("//input[@id='txtDate']")).click();
	this.delayScript(3);
    String futureDateTime = getFutureFormatedTime(1,"d-MMMMMMMMM-yyyy");
	System.out.println(futureDateTime);
	String futureDay=futureDateTime.split("-")[0].trim();
	String futureMonth = futureDateTime.split("-")[1].trim();
	String futureYear = futureDateTime.split("-")[2].trim();
	selectedDate(futureDay,  futureYear,futureMonth);
}
public void currentDate() {
	driver.findElement(By.xpath("//input[@id='txtDate']")).click();
	this.delayScript(3);
	String currentDateTime = getCurrentFormattedTime("d-MMMMMMMMM-yyyy");
	System.out.println(currentDateTime);
	String curDay=currentDateTime.split("-")[0].trim();
	String curMonth = currentDateTime.split("-")[1].trim();
	String curYear = currentDateTime.split("-")[2].trim();
	selectedDate(curDay, curYear,curMonth);
}
public void selectedDate(String futureDay,String futureYear, String futureMonth)  {
    String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
    System.out.println(month);
    String Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
    System.out.println(Year);
	while(!(futureMonth.equals(month) && futureYear.equals(Year))){
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	     month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	     Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); 
		}
	driver.findElement(By.xpath("//span[text()='"+futureMonth+"']/../span[text()='"+futureYear+"']/../../following-sibling::table//a[text()='"+futureDay+"']")).click();
	driver.findElement(By.xpath("//input[@value='Search']")).click();
}
}
