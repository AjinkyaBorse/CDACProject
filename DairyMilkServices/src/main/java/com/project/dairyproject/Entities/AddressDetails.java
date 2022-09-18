package com.project.dairyproject.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class AddressDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AID;
	
	@NotEmpty(message = "District name required")
	@Length(max = 20, message = "District name cannot be more than 20 characters")
	@Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Please enter correct district name")
	private String district;
	
	@Length(max = 20, message = "Town name cannot be more than 20 characters")
	@Pattern(regexp = "^[a-zA-Z]{0,20}$", message = "Please enter correct town name")
	private String town;
	
	@NotEmpty(message = "Pincode required")
	@Length(min = 6, max = 6, message = "Please enter correct 6 digits pincode")
	@Column(length = 6, unique = true)
	@Pattern(regexp = "^[1-9]{1}[0-9]{2}[0-9]{3}$", message = "Please enter correct 6 digits pincode number")
	private String pincode;
	
	@NotEmpty(message = "State cannot be empty")
	@Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Please enter correct state name")
	private String state;
	
	@NotEmpty
	private String country;
	
	@OneToMany(mappedBy="address")
	private List<ConsumerDetails> consumer;
	
	

	public int getAID() {
		return AID;
	}

	public void setAID(int aID) {
		AID = aID;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
