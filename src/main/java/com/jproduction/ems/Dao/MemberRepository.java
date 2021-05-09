/**
 * 
 */
package com.jproduction.ems.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jproduction.ems.Model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	public Member findByMid(int mid);
	
}
