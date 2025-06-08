package com.tcc.iot_mc_api.dto;

import com.tcc.iot_mc_api.model.user.UserRole;

public record RegisterDTO(String email, String senha, UserRole role) {
    
}
