package com.netcracker.security;

import com.netcracker.DAO.entity.Client;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ClientService;
//import com.websystique.springmvc.model.User;
//import com.websystique.springmvc.model.UserProfile;
//import com.websystique.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	//static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private ClientService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String ssoId)
			throws UsernameNotFoundException {
		Client user = null;
		try {
			user = userService.getClientById(ssoId);
		} catch (FatalError fatalError) {
			fatalError.printStackTrace();
		}
		catch (EntityNotFound entityNotFound) {
			entityNotFound.printStackTrace();
		}
		//logger.info("User : {}", user);
		if(user==null){
			//logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
				 true, true, true, true, getGrantedAuthorities(user));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(Client user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		//for(UserProfile userProfile : user.getUserProfiles()){
			//logger.info("UserProfile : {}", userProfile);
			//authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
			authorities.add(new SimpleGrantedAuthority("ROLE_"+"ADMIN"));
		//}
		//logger.info("authorities : {}", authorities);
		return authorities;
	}
	
}
