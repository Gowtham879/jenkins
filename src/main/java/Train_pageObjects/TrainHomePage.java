package Train_pageObjects;

import SeleniumCommands.AllCommands;

public class TrainHomePage extends AllCommands{
	private void trainClick() {
		String xpath="//div[@class='ng-scope']//a[@href='https://www.easemytrip.com/railways/']";
		this.click(xpath);
	}
	private void from() {
		String xpath="//input[@id='txtfromcity']";
		this.click(xpath);
	}
	private void to() {
		String xpath="//input[@id='txtdesticity']";
		this.click(xpath);
	}
	private void source(String from) {
		String xpath="//div[text()='"+from+"']";
		this.click(xpath);
	}
	private void destination(String to) {
		String xpath="//input[@id='txtdesticity']/../descendant::div[text()='"+to+"']";
		this.click(xpath);
	}
public void traintickets(String from, String to) {
	this.trainClick();
	this.delayScript(2);
	this.from();
	this.delayScript(2);
	this.source(from);
	this.delayScript(2);
	this.to();
	this.delayScript(2);
	this.destination(to);
	
}
}
