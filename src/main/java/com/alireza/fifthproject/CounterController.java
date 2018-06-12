package com.alireza.fifthproject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("")
	public String index(HttpSession session) {
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counterIndex(HttpSession session,Model model) {
		
        if (session.getAttribute("count") == null) {
        	Integer count = 0;
			session.setAttribute("count", count);
        } else {
        	Integer count = (Integer) session.getAttribute("count");
        	session.setAttribute("count", count+1);
        	model.addAttribute("counter", count);
        }
		return "counter.jsp";
	}
	@RequestMapping("/reset")
	public String backIndex(HttpSession session,Model model) {
		
		session.setAttribute("count", 0);
		return "redirect:/";           	
	}
	@RequestMapping("/two")
	public String byTwo(HttpSession session,Model model) {
		Integer count = (Integer) session.getAttribute("count");
    	session.setAttribute("count", count+2);
    	model.addAttribute("counterTwo", count);
		return "counterbyTwo.jsp";           	
	}
}
