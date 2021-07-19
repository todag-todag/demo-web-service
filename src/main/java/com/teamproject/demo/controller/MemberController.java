package com.teamproject.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.demo.service.MemberServiceImpl;
import com.teamproject.demo.vo.MemberVO;


@Controller
public class MemberController {
	
    @Autowired
    MemberServiceImpl memberServiceImpl;

    @RequestMapping(value="/SignIn", method = RequestMethod.GET)
    public String signin() throws Exception {
        return "signin";
    }
    
    
    @RequestMapping(value="/SignIn", method = RequestMethod.POST)
    ModelAndView signin(@RequestParam(value="id",required=true) String id, @RequestParam(value="password",required=true) String password, HttpServletRequest request) throws Exception {
    	ModelAndView modelAndView = new ModelAndView();
    	try {
    		System.out.println("MemberController "+ id);
    		System.out.println("MemberController "+ password);

    		MemberVO result = memberServiceImpl.searchMember(id, password);
    		
    		System.out.println("MemberController after "+ result.getId());
    		System.out.println("MemberController after "+ result.getName());
			
    		HttpSession session = request.getSession();
			session.setAttribute("id", id);
			modelAndView.addObject("restult", "로그인 성공");
			modelAndView.setViewName("index");

			
		} catch(Exception e) {
			e.printStackTrace();
			modelAndView.addObject("restult", "로그인 오류");
			modelAndView.setViewName("signin");
		}
    	return modelAndView;
    }
    
    @RequestMapping("/SignUp")
    public String signup() throws Exception {
        return "signup";
    }

}