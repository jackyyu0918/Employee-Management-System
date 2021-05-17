package com.jproduction.ems.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jproduction.ems.Dao.emsOrg.MemberRepository;
import com.jproduction.ems.Service.MemberService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberService memberService;

	// Home page
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "Hello this is your home page";
	};



	// return HTML page under /src/resource/templates
	@RequestMapping("/Message")
	public String index() {
		return "index";
	}


}