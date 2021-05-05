/**
 * 
 */
package com.jproduction.ems.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jproduction.ems.Model.Member;

/**
 * @author Kit
 *
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
	
	
	
}
