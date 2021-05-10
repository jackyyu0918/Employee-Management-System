package com.jproduction.ems.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jproduction.ems.Dao.emsOrg.MemberRepository;
import com.jproduction.ems.Service.MemberService;

@RestController
public class HomeController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberService memberService;
	
	// Home page
	@RequestMapping("/")   
	public String home() {
		return "Hello this is your home page";
	};
	
}
