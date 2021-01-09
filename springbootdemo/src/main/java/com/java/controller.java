package com.java;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {
    @Autowired
	private  servise serv;
    
    @RequestMapping("/")
    public String viewHomePage(Model model){
    	List<Employee> listempl=serv.listAll();
    	model.addAttribute("listempl", listempl);
    	
		return "index";
    	
    }
    
    @RequestMapping("/new")
    public String shownewEmployee(Model model){
    	Employee emp=new Employee();
    	model.addAttribute("emp", emp);
		return "new_employee";
    	
    	
    }
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public  String saveemployee(@ModelAttribute("employee") Employee employee){
    	serv.save(employee);
    	return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView editemployee(@PathVariable(name="id")Long id){
    	ModelAndView mav=new ModelAndView("edit_employee");
    	Employee emple=serv.get(id);
    	mav.addObject("emple",emple);
    	return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteemployee(@PathVariable(name="id")Long id){
    	serv.delete(id);
    	return "redirect:/";
    }
    
}

