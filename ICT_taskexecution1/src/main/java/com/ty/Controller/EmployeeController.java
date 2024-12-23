package com.ty.Controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.DAO.EmployeeDao;
import com.ty.Entity.userEntity;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@ModelAttribute("genderlist")
	public List<String> getGender() {
		List<String> list = new ArrayList<String>();
		list.add("male");
		list.add("female");
		list.add("Others");
		return list;
	}

	@ModelAttribute("interestList")
	public List<String> getInterset() {
		List<String> list = new ArrayList<String>();
		list.add("Travelling");
		list.add("Tracking");
		list.add("Sports");
		return list;
	}

	@ModelAttribute("familyincomelist")
	public List<String> getFamilyIncome() {
		List<String> list = new ArrayList<String>();
		list.add("Up to 1lac");
		list.add("1 lac to 5 lac");
		list.add("5 lac to 10 lac");
		list.add("10 lac and above");
		return list;
	}

	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("user", new userEntity());
		return "register";
	}

	@PostMapping("save")
	public String save(@ModelAttribute("user") userEntity user) {
		this.employeeDao.save(user);
		return "redirect:read";
	}

	@GetMapping("read")
	public ModelAndView read(ModelAndView modelAndView) {
		modelAndView.addObject("use", this.employeeDao.getAllUsers());
		modelAndView.setViewName("read");
		return modelAndView;
	}

	@GetMapping("edit")
	public ModelAndView edit(@RequestParam("id") int id, ModelAndView modelAndView) {
		modelAndView.addObject("user", this.employeeDao.getUserById(id));
		modelAndView.setViewName("update");
		return modelAndView;
	}

	@PostMapping("update")
	public String update(@ModelAttribute("user") userEntity user) {
		this.employeeDao.update(user);
		return "redirect:read";
	}

	@GetMapping("delete")
	public String delete(@RequestParam("id") int id) {
		this.employeeDao.delete(id);
		return "redirect:read";
	}

}
