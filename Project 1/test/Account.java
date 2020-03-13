package com.revature.test;

public class Account {
	
	private int empid;
	private String username;
	private String password;
	private int roleid;
	private double year_fund;
	
	
	
	

	public double getYear_fund() {
		return year_fund;
	}
	public void setYear_fund(double year_fund) {
		this.year_fund = year_fund;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empid;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + roleid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		long temp;
		temp = Double.doubleToLongBits(year_fund);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (empid != other.empid)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roleid != other.roleid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (Double.doubleToLongBits(year_fund) != Double.doubleToLongBits(other.year_fund))
			return false;
		return true;
	}
	
	 
	public Account(int empid, String username, String password, int roleid, double year_fund) {
		super();
		this.empid = empid;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
		this.year_fund = year_fund;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}


