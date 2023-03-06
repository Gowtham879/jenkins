package Bus_pageObjects;

import SeleniumCommands.AllCommands;

public class SeatSlectionPage extends AllCommands{
private void selectseats() {
	String xpath="//span[contains(.,'S')]/../../../descendant::a[text()='Select Seats']";
	this.click(xpath);
}
private void boardingselect() {
	String xpath="//label[text()='Select a Boarding Point']/.. //a[text()='---Select---']";
	this.click(xpath);
}
private void boardingpoint() {
	String xpath="//label[text()='Select a Boarding Point']/.. //a[text()='---Select---']/../descendant::a[contains(.,' Majestic Ananda')]";
	this.click(xpath);
}
private void dropingselect() {
	String xpath="//label[text()='Select a Dropping Point']/.. //a[text()='---Select---']";
	this.click(xpath);
}
private void dropingpint() {
	String xpath="//label[text()='Select a Dropping Point']/.. //a[text()='---Select---']/../descendant::a[text()=' Bijapur']";
	this.click(xpath);
}
private void seat() {
	String xpath="//div[text()='11U']";
	this.click(xpath);
}
private void contin() {
	String xpath="//a[text()='Continue']";
	this.click(xpath);
}
public void SeatSelection() {
	this.delayScript(2);
	this.selectseats();
	this.delayScript(4);
	this.boardingselect();
	this.delayScript(4);
	this.boardingpoint();
	this.delayScript(4);
	this.dropingselect();
	this.delayScript(4);
	this.dropingpint();
	this.delayScript(4);
	this.seat();
	this.delayScript(4);
	this.contin();
}
}
