/*2.page：页面层，提供元素的获取及各个元素操作方法的封装*/
package com.po.page;

import org.openqa.selenium.By;

public class LoginPage {
	/*把登陆页面中的元素定位都声明在这里*/
	public static By emailInput =By.name("email");
	public static By pwdInput =By.name("password");
	public static By loginButton =By.id("dologin");
	public static By registerButton =By.id("changepage");

}
