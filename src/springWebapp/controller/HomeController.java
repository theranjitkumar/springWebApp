package springWebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView defaultPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("title", "Home");
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about.jsp");
		mv.addObject("title", "About");
		return mv;
	}	

}
