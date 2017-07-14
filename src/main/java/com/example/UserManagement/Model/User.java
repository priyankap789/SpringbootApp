package com.example.UserManagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserTable")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ssoid;
	
	@Column(name = "userFirstName")
	private String userFirstName;
	
	@Column(name = "userLastName")
	private String userLastName;
	
	@Column(name = "contactInfo")
	private String contactInfo;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "roles")
	private String roles;
	
	@Column(name = "Description")
	private String Description;
	
	@Column(name = "noOfVisit")
	private long noOfVisit;


	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public long getNoOfVisit() {
		return noOfVisit;
	}
	public void setNoOfVisit(long noOfVisit) {
		this.noOfVisit = noOfVisit;
	}
	
	public long getSsoid() {
		return ssoid;
	}
	public void setSsoid(long ssoid) {
		this.ssoid = ssoid;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	protected User() {
		
	}
 
	public User(String firstName, String lastName,String  contactInfo, String emailId,
			String roles, String Desciption, long noOfVisit ) {
		this.userFirstName = firstName;
		this.userLastName = lastName;
		this.contactInfo = contactInfo;
		this.emailId = emailId;
		this.roles =roles;
		this.Description = Desciption;
		this.noOfVisit = noOfVisit;
	}
	
}
