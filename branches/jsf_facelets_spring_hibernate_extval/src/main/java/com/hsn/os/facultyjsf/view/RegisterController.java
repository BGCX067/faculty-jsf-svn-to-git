package com.hsn.os.facultyjsf.view;

import java.io.Serializable;

import org.apache.myfaces.extensions.validator.baseval.annotation.Length;
import org.apache.myfaces.extensions.validator.baseval.annotation.LongRange;
import org.apache.myfaces.extensions.validator.baseval.annotation.Required;
import org.apache.myfaces.extensions.validator.crossval.annotation.Equals;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("registerController")
@Scope("request")
public class RegisterController implements Serializable {

	@Required(validationErrorMsgKey = "username_missing")
	@Length(minimum = 5, maximum = 20)
	private String userName;
	
	@Required(validationErrorMsgKey = "password_missing")
	@Length(minimum = 6, maximum = 20)	
	@Equals(value = "password2", validationErrorMsgKey = "passwords_not_matched") //cross-validation
	private String password;
	
	@Required(validationErrorMsgKey = "password_missing")
	@Length(minimum = 6, maximum = 20)
	private String password2;
	
	@Required(validationErrorMsgKey = "address_missing")
	@Length(minimum = 6, maximum = 35)
	private String address;
	
	@Required(validationErrorMsgKey = "age_missing")
	@LongRange(minimum = 1, maximum = 100)
	private String age;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String register() {
		return "";
	}
	
	
}