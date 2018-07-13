package springWebapp.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.javafx.text.ScriptMapper;

import springWebapp.modal.Student;

@Controller
public class HomeController {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	 	
	@RequestMapping("/")
	public ModelAndView defaultPage(){
		String sql = "SELECT * FROM student";
		
//		public List<Student> findAllStudents() {
//		    return this.jdbcTemplate.query( "select name, city from student", new ScriptMapper());
//		}
//
//		private static final class StudentMapper implements ScriptMapper {
//
//		    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//		    	Student student = new Student();
//		    	student.setName(rs.getString("name"));
//		    	student.setCity(rs.getString("city"));
//		        return student;
//		    }
//		}
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("title", "Home");
		return mv;
	}

	@RequestMapping(path="/add")
	public ModelAndView add(){
		this.jdbcTemplate.update("insert into student(id,name,city) values(?,?,?)",103, "kallu","ggn");
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
