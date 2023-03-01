package Bus_pageObjects;

import SeleniumCommands.AllCommands;

public class BusHomePage extends AllCommands{
	private void busClick() {
		String xpath="//div[@class='emt_nav']//a[@href='https://www.easemytrip.com/bus/']";
		this.click(xpath);
	}
	private void from() {
		String xpath="//input[@id='txtSrcCity']";
		this.click(xpath);
	}
	private void to() {
		String xpath="//input[@id='txtDesCity']";
		this.click(xpath);
	}
	private void source() {
		String xpath="//input[@id='txtSrcCity']/../descendant::li[contains(.,'Bangalore')]";
		this.click(xpath);
	}
	private void destination() {
		String xpath="//input[@id='txtDesCity']/../descendant::li[contains(.,'Bijapur')]";
		this.click(xpath);
	}
public void tickets() {
	this.busClick();
	this.delayScript(2);
	this.from();
	this.delayScript(2);
	this.source();
	this.delayScript(2);
	this.to();
	this.delayScript(2);
	this.destination();
	
}

}
