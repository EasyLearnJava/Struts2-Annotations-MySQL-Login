package com.easylearnjava.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.easylearnjava.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

@ResultPath(value="/")
@Results({
	 @Result(name="success", location="/loginSuccess.jsp"),
	 @Result(name="failure", location="/login.jsp")
	})
public class LoginAction extends ActionSupport {

	/**
	 * This is auto generated
	 */
	private static final long serialVersionUID = -8394168031846902591L;

	private String username;
	private String password;

	@Action(value="/login")
	public String execute() {
		
		Boolean validData = true;
		try{			
			if (username == null || ("".equals(username))) {
				addActionError(getText("error.name.required"));
				validData = false;
			}

			if (password == null || ("".equals(password))) {
				addActionError(getText("error.password.required"));
				validData = false;
			}
			
			if(!validData){
				return "failure";
			}
			
			LoginService ls = new LoginService();
			boolean isValid = ls.isValidPassword(this.username, this.password);

			if (isValid) {				
				return "success";
			} else {				
				addActionError(getText("login.failed"));
				return "failure";
			}
		}catch(Exception e){
			addActionError(getText("global.exception.message"));
			return "failure";
		}
	}

	@RequiredFieldValidator( message = "username is required")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@RequiredFieldValidator( message = "password is required")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
