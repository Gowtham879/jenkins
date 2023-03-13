package Flight_pageObjects;

import SeleniumCommands.AllCommands;

public class FlightTravellers extends AllCommands {
	private void traveller() {
		String xpath="//p[@id='ptravlr']";
		this.click(xpath);
	}
	private void adults() {
		String xpath="//p[@id='ptravlr']/../following-sibling::div//p[text()='Adults']/../following-sibling::div//button[@id='add']";
		this.click(xpath);
	}
	private void children() {
		String xpath="//p[@id='ptravlr']/../following-sibling::div//p[text()='Children']/../following-sibling::div//button[@id='add']";
		this.click(xpath);
	}
	private void infant() {
		String xpath="//p[@id='ptravlr']/../following-sibling::div//p[text()='Infant']/../following-sibling::div//button[@id='add']";
		this.click(xpath);
	}
	private void search() {
		String xpath="//button[text()=' Search']";
		this.click(xpath);
		
	}
	private void booknow() {
		String xpath="//div[text()='Book Now']";
//	    this.explicit(xpath);
		this.click(xpath);
	}
	private void contin() {
		String xpath="//div[@class='footerfare']//a[text()='Continue']";
		this.click(xpath);
	}
	public void deatils() {
		this.traveller();
		this.delayScript(2);
		this.adults();
		this.delayScript(2);
		this.children();
		this.delayScript(2);
		this.infant();
		this.delayScript(2);
		this.search();
	    this.delayScript(5);
		this.booknow();
		this.delayScript(4);
		this.contin();
	}

}
