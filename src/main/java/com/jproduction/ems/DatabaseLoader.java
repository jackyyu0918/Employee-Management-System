package com.jproduction.ems;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jproduction.ems.Dao.MemberRepository;
import com.jproduction.ems.Model.Member;

@Component
public class DatabaseLoader implements CommandLineRunner {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// 3 dot usage: zero more multiple number of arguments
		//https://stackoverflow.com/questions/3158730/what-do-3-dots-next-to-a-parameter-type-mean-in-java
		
		Member member = new Member("m01","Jacky", "Yu", "jackyyu.work@gmail.com", "password123", new Date(), new Date());
	
		memberRepository.save(member);
	
	}
	
	
	
}
