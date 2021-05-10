package com.jproduction.ems.Service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jproduction.ems.Dao.emsOrg.MemberRepository;
import com.jproduction.ems.Model.emsOrg.Member;
import com.jproduction.ems.Service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
//	@Override
//	public Member saveMember(Member member) {
//		member.setMid(1);
//        member.setCreatetime(new Date());
//        memberRepository.save(member);
//        return member;
//	}

}
