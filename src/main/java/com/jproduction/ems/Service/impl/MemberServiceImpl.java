package com.jproduction.ems.Service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.jproduction.ems.Dao.MemberRepository;
import com.jproduction.ems.Model.Member;
import com.jproduction.ems.Service.MemberService;

public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member saveMembe(Member member) {
		member.setMid(UUID.randomUUID().toString().replaceAll("-", ""));
        member.setCreatetime(new Date());
        memberRepository.save(member);
        return member;
	}

}
