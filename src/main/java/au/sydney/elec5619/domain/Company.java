package au.sydney.elec5619.domain;

import java.net.URL;
import java.sql.Date;


public class Company {

	private String email;
	private String password;	
	private String companyname;
	private String companycode;
	
	private String licence;
	private URL homepage;
	
	private Date establishdate;
	
	private String companytype;
	private String location;
	private int scale;
	private String phone;
	private boolean audit;
	private boolean ban;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isAudit() {
		return audit;
	}

	public void setAudit(boolean audit) {
		this.audit = audit;
	}

	public Company() { }

	public Company(String username, String password) 
	{
		this.email = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}
 
	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public URL getHomepage() {
		return homepage;
	}

	public void setHomepage(URL homepage) {
		this.homepage = homepage;
	}

	public Date getEstablishdate() {
		return establishdate;
	}

	public void setEstablishdate(Date establishdate) {
		this.establishdate = establishdate;
	}



	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public boolean isBan() {
		return ban;
	}

	public void setBan(boolean ban) {
		this.ban = ban;
	}

	public boolean completed()
	{
		return (this.companyname != null) && (this.companycode != null) && (this.licence != null);		
	}

	@Override
	public String toString() {
		return "Company [email=" + email + ", password=" + password + ", companyname=" + companyname + ", companycode="
				+ companycode + ", licence=" + licence + ", homepage=" + homepage + ", establishdate=" + establishdate
				+ ", companytype=" + companytype + ", location=" + location + ", scale=" + scale + ", phone=" + phone
				+ ", audit=" + audit + ", ban=" + ban + "]";
	}
	
}
