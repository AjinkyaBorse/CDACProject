package com.project.dairyproject.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dairyproject.Entities.Administrator;
import com.project.dairyproject.LoginEntities.ChangePassword;
import com.project.dairyproject.Repository.AdministratorRepository;
import com.project.dairyproject.UserDefinedExceptions.IncorrectPasswordException;
import com.project.dairyproject.UserDefinedExceptions.UnmatchedPasswordException;

@Service
@Transactional
public class AdminServices {

	@Autowired
	private AdministratorRepository adminRepo;

	@Autowired
	private Administrator adminDetails;

	public Administrator getAdminDetails() {
		return adminRepo.findAdminDetails();
	}

	public String changeAdminPassword(ChangePassword changePassword) {
		adminDetails = adminRepo.findAdminDetails();
		if (adminDetails.getPassword().equals(changePassword.getOldPassword())) {
			if (changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
				adminDetails.setPassword(changePassword.getNewPassword());
				adminRepo.save(adminDetails);
				return "Administrator Password Changed...!";
			} else {
				throw new UnmatchedPasswordException("Passoword does not match. please enter correct password");
			}
		} else {
			throw new IncorrectPasswordException("Incorrect Old Password !");
		}
	}

	public Administrator getLoginDetails(String emailId, String password) {
		return adminRepo.findAdminDetailsByEmailIdAndPassword(emailId, password);
	}

}
