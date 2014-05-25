package com.easylearnjava.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success", location="/login.jsp")
public class LogoutAction {
	
	@Action(value="/logout")
	public String execute() {
		return "success";
	}

}
