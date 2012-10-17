package co.ntier.training.simplemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({"/", "/home"})
	public String getHome(Model model) {
		return "home";
	}
	
	@RequestMapping("/secure/test")
	public String getSecureTest(Model model) {
		return "home";
	}

}
