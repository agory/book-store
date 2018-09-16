package com.example.bookstore.facades;

import com.example.bookstore.dto.RegisterVO;
import com.example.bookstore.entities.Role;
import com.example.bookstore.entities.User;
import com.example.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserFacade implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }

    public void register(RegisterVO registerVO) {
        String password = passwordEncoder.encode(registerVO.getPassword());
        User user = new User(registerVO.getUsername(), password);
        user.addRole(new Role(1L, "USER"));
        user.addRole(new Role(2L, "Admin"));
        this.userRepository.save(user);
    }
}
