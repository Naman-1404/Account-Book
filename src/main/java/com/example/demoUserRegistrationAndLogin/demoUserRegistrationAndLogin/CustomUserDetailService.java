package com.example.demoUserRegistrationAndLogin.demoUserRegistrationAndLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =repo.findByEmail(email);
        if(user == null)
        {
            throw new UsernameNotFoundException("User Name Doesn't Exist");
        }
        return new CustomUserDetail(user);
    }

    public User getUserById(long id){
        Optional<User> optional = repo.findById(id);

        User user = null;
        if (optional.isPresent()){
            user = optional.get();
        }else {
            throw new RuntimeException("User doesn't exist for id:: " + id);
        }
        return user;
    }


    public void deleteUserById(long id){

        this.repo.deleteById(id);

    }

}
