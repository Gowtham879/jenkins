package Flight_pageObjects;

import SeleniumCommands.AllCommands;

public class FlightBookingHomePage extends AllCommands{
private void from() {
	String xpath="//div[@id='frmcity']";
	this.click(xpath);
}
private void to() {
	String xpath="//div[@id='tocity']";
	this.click(xpath);
}
private void source(String Source) {
	String xpath="//div[@id='frmcity']/following-sibling::div//span[text()='"+Source+"']";
	this.click(xpath);
}
private void destination(String Destination) {
	String xpath="//div[@id=\"tocity\"]/following-sibling::div//span[text()='"+Destination+"']";
	this.click(xpath);
}
public void journy(String Source, String Destination) {
	this.delayScript(3);
	this.from();
	this.delayScript(2);
	this.source(Source);
	this.delayScript(2);
	this.to();
	this.delayScript(2);
	this.destination(Destination);
}
}
