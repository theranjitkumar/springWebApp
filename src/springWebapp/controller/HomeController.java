package springWebapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String defaultPage(){
		return "hello form spring app";
	}
	
	@RequestMapping("/home")
	public String home(){
		return "hello form Home";
	}	

}
