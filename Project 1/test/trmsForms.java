package com.revature.test;

import java.sql.Timestamp;

public class trmsForms {
	
	private int formid;
	private int empid;
	private String name;
	private String address;
	private String phone;
	private String type;
	private String description;
	private String location;
	private String submit_date;
	private String start_date;
	private String is_urgent;
	private double cost;
	private double reimbursement_amount;
	private String grading_format;
	private String ds_approved;
	private String dh_approved;
	private String bc_approved;
	private double awarded;
	
	
	public int getFormid() {
		return formid;
	}
	public void setFormid(int formid) {
		this.formid = formid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSubmit_date() {
		return submit_date;
	}
	public void setSubmit_date(String submit_date) {
		this.submit_date = submit_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getIs_urgent() {
		return is_urgent;
	}
	public void setIs_urgent(String is_urgent) {
		this.is_urgent = is_urgent;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getReimbursement_amount() {
		return reimbursement_amount;
	}
	public void setReimbursement_amount(double reimbursement_amount) {
		this.reimbursement_amount = reimbursement_amount;
	}
	public String getGrading_format() {
		return grading_format;
	}
	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}
	public String getDs_approved() {
		return ds_approved;
	}
	public void setDs_approved(String ds_approved) {
		this.ds_approved = ds_approved;
	}
	public String getDh_approved() {
		return dh_approved;
	}
	public void setDh_approved(String dh_approved) {
		this.dh_approved = dh_approved;
	}
	public String getBc_approved() {
		return bc_approved;
	}
	public void setBc_approved(String bc_approved) {
		this.bc_approved = bc_approved;
	}
	public double getAwarded() {
		return awarded;
	}
	public void setAwarded(double awarded) {
		this.awarded = awarded;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(awarded);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bc_approved == null) ? 0 : bc_approved.hashCode());
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dh_approved == null) ? 0 : dh_approved.hashCode());
		result = prime * result + ((ds_approved == null) ? 0 : ds_approved.hashCode());
		result = prime * result + empid;
		result = prime * result + formid;
		result = prime * result + ((grading_format == null) ? 0 : grading_format.hashCode());
		result = prime * result + ((is_urgent == null) ? 0 : is_urgent.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		temp = Double.doubleToLongBits(reimbursement_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((submit_date == null) ? 0 : submit_date.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		trmsForms other = (trmsForms) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(awarded) != Double.doubleToLongBits(other.awarded))
			return false;
		if (bc_approved == null) {
			if (other.bc_approved != null)
				return false;
		} else if (!bc_approved.equals(other.bc_approved))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dh_approved == null) {
			if (other.dh_approved != null)
				return false;
		} else if (!dh_approved.equals(other.dh_approved))
			return false;
		if (ds_approved == null) {
			if (other.ds_approved != null)
				return false;
		} else if (!ds_approved.equals(other.ds_approved))
			return false;
		if (empid != other.empid)
			return false;
		if (formid != other.formid)
			return false;
		if (grading_format == null) {
			if (other.grading_format != null)
				return false;
		} else if (!grading_format.equals(other.grading_format))
			return false;
		if (is_urgent == null) {
			if (other.is_urgent != null)
				return false;
		} else if (!is_urgent.equals(other.is_urgent))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (Double.doubleToLongBits(reimbursement_amount) != Double.doubleToLongBits(other.reimbursement_amount))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (submit_date == null) {
			if (other.submit_date != null)
				return false;
		} else if (!submit_date.equals(other.submit_date))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "trmsForms [formid=" + formid + ", empid=" + empid + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", type=" + type + ", description=" + description + ", location=" + location
				+ ", submit_date=" + submit_date + ", start_date=" + start_date + ", is_urgent=" + is_urgent + ", cost="
				+ cost + ", reimbursement_amount=" + reimbursement_amount + ", grading_format=" + grading_format
				+ ", ds_approved=" + ds_approved + ", dh_approved=" + dh_approved + ", bc_approved=" + bc_approved
				+ ", awarded=" + awarded + "]";
	}
	public trmsForms(int formid, int empid, String name, String address, String phone, String type, String description,
			String location, String submit_date, String start_date, String is_urgent, double cost,
			double reimbursement_amount, String grading_format, String ds_approved, String dh_approved,
			String bc_approved, double awarded) {
		super();
		this.formid = formid;
		this.empid = empid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.type = type;
		this.description = description;
		this.location = location;
		this.submit_date = submit_date;
		this.start_date = start_date;
		this.is_urgent = is_urgent;
		this.cost = cost;
		this.reimbursement_amount = reimbursement_amount;
		this.grading_format = grading_format;
		this.ds_approved = ds_approved;
		this.dh_approved = dh_approved;
		this.bc_approved = bc_approved;
		this.awarded = awarded;
	}
	public trmsForms() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
