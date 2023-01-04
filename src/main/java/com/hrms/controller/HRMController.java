package com.hrms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.hrms.repository.entity.DepartmentEntity;
import com.hrms.repository.entity.HRMEntity;
import com.hrms.service.HRMService;

@Controller
public class HRMController {
	@Autowired
	private HRMService hrmService;
	@GetMapping("/dep")
	public String showAddDepartment()
	{
		return "adddepartments";
	}
	
	@PostMapping("/dep")
	public String addDepartments(DepartmentEntity departmentEntity) {
		DepartmentEntity _departmentEntity = hrmService.addDepartments(departmentEntity);
		
		return "redirect:adminhome";
	}
	
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/log")
	public String login(HRMEntity hrmEntity, HttpServletRequest request) {
		
		HRMEntity hrm = hrmService.getHRMAdmin(hrmEntity.getUserName(), hrmEntity.getPassword());
		System.out.println("user details are " + hrm);
		
		System.out.println(hrm != null);
		if (hrm != null) {

			HttpSession session = request.getSession();
			System.out.println("If");
			session.setAttribute("AUTH_HRM", hrm);
			return "redirect:adminhome";
		} else {
			return "redirect:login?errorMessage=Invaid userName or password";
		}

	}
	@GetMapping("/adminhome")
	public String userHome(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {

			HRMEntity hrm = (HRMEntity) session.getAttribute("AUTH_HRM");
			System.out.println("AUTH_HRM" + hrm);
			if (hrm != null) {

				return "adminhome";
			}
		}
		return "redirect:login";
	}
	@GetMapping("/logout")
	public String logOut(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login";
	}

	@GetMapping("/changepassword")
	public String showChangePassword(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			HRMEntity auth_hrm = (HRMEntity) session.getAttribute("AUTH_HRM");
			if (auth_hrm != null) {
				return "adminhome";
			}
		}
		return "redirect:adminhome";
	}
	@PostMapping("/changepassword")
	public String changePassword(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			HRMEntity auth_hrm = (HRMEntity) session.getAttribute("AUTH_HRM");
			if (auth_hrm != null) {
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				String confirmPassword = request.getParameter("confirmPassword");
				if (oldPassword.equals(auth_hrm.getPassword()) && newPassword.equals(confirmPassword)) {
					auth_hrm.setPassword(newPassword);
					hrmService.addDepartments(null);
				}
				return "adminhome";
			}
		}
		return "redirect:adminhome";
	}
	@GetMapping("/editprofile")
	public String showEditProfile(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			HRMEntity auth_hrm = (HRMEntity) session.getAttribute("AUTH_HRM");
			if (auth_hrm != null) {
				return "adminhome";
			}
		}
		return "redirect:adminhome";
	}

	
	@GetMapping("/adddepartmentcategory")
	public String addDepartmentCategory()
	{
		return "adddepartmentcategory";
	}

	

}
