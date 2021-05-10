package com.jproduction.ems.Controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jproduction.ems.Dao.emsOrg.MemberRepository;
import com.jproduction.ems.Model.emsOrg.Member;
import com.jproduction.ems.Service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository; // this is an interface
	
//	@Autowired
//	private MemberService memberService; // this is an interface
	                                        
	@GetMapping("/members")             
	public Collection<Member> getAllMembers() {
		return memberRepository.findAll();
	}
	
	@GetMapping("/member/{mid}")
	public ResponseEntity<?> getMember(@PathVariable int mid) {
        Optional<Member> member = Optional.of(memberRepository.findByMid(mid)); //wrapped with optional !?
        return member.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
//	// After adding business logic (service)
//	@PostMapping("/member")
//	public ResponseEntity<Member> createMember(@RequestBody Member member){
//		
//		return null;
//		
//		// @RequestBody
//		// https://blog.csdn.net/justry_deng/article/details/80972817
//		
//	}
	
	
	
	
	
	
	
	
	
}
