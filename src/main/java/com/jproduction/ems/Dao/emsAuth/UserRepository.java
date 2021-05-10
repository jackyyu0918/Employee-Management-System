package com.jproduction.ems.Dao.emsAuth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jproduction.ems.Model.emsAuth.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);
	
}
