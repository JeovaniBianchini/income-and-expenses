package com.bianchinijeovani.incomeandexpenses.config.security;

import com.bianchinijeovani.incomeandexpenses.dtos.UserForm;
import com.bianchinijeovani.incomeandexpenses.models.User;
import com.bianchinijeovani.incomeandexpenses.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return user;
    }

    public String getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UserDetails) {
            String currentUser = authentication.getName();
            return currentUser;
        } else {
            return authentication.toString();
        }
    }

    public User save(UserForm userForm) {
        BCryptPasswordEncoder passWordEncoder = new BCryptPasswordEncoder();
        String passWord = passWordEncoder.encode(userForm.getPassWord());
        User user = new User();
        user.setUserName(userForm.getUserName());
        user.setPassWord(passWord);
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return user;
    }


}
