package com.demo.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.User;

@Controller
public class LoginController {
	@PersistenceContext
	EntityManager em;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public ModelAndView processLogin(@RequestParam("username") String userName,
			@RequestParam("password") String passWord)
	{
//		ModelAndView mv = new ModelAndView();
//		if(userName.equals(passWord)){
//			mv.setViewName("success");
//			mv.addObject("user", userName);
//		}
//		else{
//			mv.setViewName("failure");
//		}
//		return mv;
		ModelAndView mv = new ModelAndView();	
		User usersObj = em.find(User.class, userName);
		if(usersObj != null)
		{
			if(usersObj.getPassword().equals(passWord))
			{
				mv.setViewName("success");
				mv.addObject("user",userName);
			}
			else
				mv.setViewName("failure");
		}
		else
			mv.setViewName("login");
		
		
		return mv;
	}

}
