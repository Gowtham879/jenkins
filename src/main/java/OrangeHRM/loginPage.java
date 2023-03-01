package OrangeHRM;

import SeleniumCommands.AllCommands;

public class loginPage extends AllCommands{
	private void userName(String uname) {
		String xpath="//input[@name='username']";
		this.enterText(xpath, uname);
	}
	private void passWord(String password) {
		String xpath="//input[@name='password']";
		this.enterText(xpath, password);
	}
	private void login() {
		String xpath="//button[@type='submit']";
		this.click(xpath);
	}
	public void loginpage(String uname, String password) {
		this.delayScript(3);
		this.userName(uname);
		this.delayScript(2);
		this.passWord(password);
		this.delayScript(2);
		this.login();
		}

}
