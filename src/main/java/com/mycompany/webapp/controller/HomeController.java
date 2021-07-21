package com.mycompany.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value={"/", "/hlogin", "/Reception", "/diagnosis", "/inspection", "/managePatient", "/createReception"})
	public String home() {
		return "index.html";
	}
}
