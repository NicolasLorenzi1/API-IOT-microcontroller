package com.tcc.iot_mc_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcc.iot_mc_api.controller.UsersDetails;
import com.tcc.iot_mc_api.dto.UserDTO;
import com.tcc.iot_mc_api.model.User;
import com.tcc.iot_mc_api.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    public void criarUsuario(UserDTO usuarioDTO){
        userRepository.findByEmail(usuarioDTO.getEmail()).orElseThrow(() -> new RuntimeException("Email ja cadastrado!"));
           
        User user = new User(usuarioDTO.getEmail(), usuarioDTO.getSenha(), usuarioDTO.getRole());
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UsersDetails();
    }

    public List<User> listarTodosOsUsuarios(){
        return userRepository.findAll();
    }

    public void deletarUsuario(Long id){
        userRepository.deleteById(id);
    }
}
