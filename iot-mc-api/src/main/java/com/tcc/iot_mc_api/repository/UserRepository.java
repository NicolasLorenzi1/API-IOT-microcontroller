package com.tcc.iot_mc_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.tcc.iot_mc_api.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    UserDetails findByEmail(String email);
}
