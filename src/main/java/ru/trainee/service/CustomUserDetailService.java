package ru.trainee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.trainee.model.CustomUserDetails;
import ru.trainee.model.User;
import ru.trainee.repository.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username);
        System.out.println(username + "\n\n\n");

        user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return user.
                map(CustomUserDetails::new).get();
    }
}
