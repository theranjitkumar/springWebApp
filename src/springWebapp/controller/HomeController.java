package springWebapp.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	 	
	@RequestMapping("/")
	public ModelAndView defaultPage(){
		String sql = "SELECT * FROM student";
		List<Map<String, Object>> students = this.jdbcTemplate.queryForList(sql);
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "Home");
		mv.addObject("students", students);
		mv.setViewName("home.jsp");
		return mv;
	}

	@RequestMapping(path="/", method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id"); //103;
		String name = request.getParameter("name"); //"Amit";
		String city =  request.getParameter("city"); //"Gurgaon";
		this.jdbcTemplate.update("insert into student(id,name,city) values(?,?,?)",id, name,city);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("title", "added");
		return mv;
	}	
	@RequestMapping(path="/update")
	public ModelAndView update(){
		this.jdbcTemplate.update("update student set city=? where id=?","ilahabad",103);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("title", "updated");
		return mv;
	}
	@RequestMapping(path="/delete")
	public ModelAndView delete(){
		this.jdbcTemplate.update("delete from student  where id = ?", Long.valueOf(103));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("title", "deleted");
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
