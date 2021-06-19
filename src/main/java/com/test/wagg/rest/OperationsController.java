package com.test.wagg.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.wagg.service.OperationsService;

@RestController
@RequestMapping("/")
public class OperationsController {
	
	@Autowired
	private OperationsService service;

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(path = "/calculate", params = {"number", "operation"})
	public ModelAndView calculate(@RequestParam int number, @RequestParam String operation, ModelMap model) {
		model.addAttribute("result", service.recieveValues(number, operation));
		model.addAttribute("operation", operation);
		return new ModelAndView("result", model);
	}

}
