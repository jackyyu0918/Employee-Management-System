package com.jproduction.ems.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jproduction.ems.Dao.emsAuth.UserRepository;
import com.jproduction.ems.Model.emsAuth.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user == null)
			throw new UsernameNotFoundException("User not found, 404");
		
		return new UserPrincipal(user);
		
	}
	
}
