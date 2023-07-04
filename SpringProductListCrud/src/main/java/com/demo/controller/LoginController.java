package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/mylogin")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
    @RequestMapping("/login")
	public String displayLogin() {
		return "login";
	}
	
    @PostMapping("/validate")
    public ModelAndView validateUser(HttpSession session,@RequestParam String uname,@RequestParam String pass){
    	System.out.println("inside validate");
    	MyUser u1=loginService.verifyUser(uname,pass);
    	System.out.println(u1);
    	session.setAttribute("user", u1);
    	if(u1!=null) {
    		System.out.println("inside if");
    		return new ModelAndView("redirect:/product/displayproduct");
    	}else {
    		System.out.println("inside else");
    		return new ModelAndView("login","msg","Enter valid credentials");
    	}

    }
    
    @RequestMapping("/logout")
    public ModelAndView logout() {
    	return new ModelAndView("login","msg","Thank you for visiting!!!");
    }
	

}
