package com.think.app.entity.user;

public class User
{
	
	private String firstName;

	private String lastName;

	private String mailAddress;

	private String password;
	
	public String getMailAddress()
	{
		return mailAddress;
	}
	public void setMailAddress(String mailAddress)
	{
		this.mailAddress = mailAddress;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
}
