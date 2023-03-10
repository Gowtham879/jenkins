package Train_pageObjects;

import SeleniumCommands.AllCommands;

public class SeatBookinPage extends AllCommands {
private void booknow() {
	String xpath="//div[text()='Sampark Kranti']/../../../following-sibling::div//span[text()='Tatkal']/../../../following-sibling::div//span[text()='AC 3 Tier']";
	this.click(xpath);
}
private void Coach() {
	String xpath="//div[text()='Sampark Kranti']/../../../following-sibling::div//span[text()='Tatkal']/../../../following-sibling::div//span[text()='AC 2 tier']/../../../../../../../../following-sibling::div//button[text()='Book Now']";
//	this.explicit(xpath);
	this.click(xpath);
}
private void confirm() {
	String xpath="//div[@class='wl_rightcol']//button[@ng-click='travellerPage()']";
//	this.explicit(xpath);
	this.click(xpath);
}
public void booking() {
	this.booknow();
	this.delayScript(2);
//	this.Coach();
	this.delayScript(2);
	this.confirm();
}
}
