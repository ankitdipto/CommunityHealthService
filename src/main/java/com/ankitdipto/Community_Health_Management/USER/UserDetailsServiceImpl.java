package com.ankitdipto.Community_Health_Management.USER;

import java.text.MessageFormat;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MyUser> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) 
        {
            //System.out.println("User with name "+username+" exists");
            //System.out.println(optionalUser.toString());
            //User user=optionalUser.get();
            
            //String encrypted_password=bCryptPasswordEncoder.encode(user.getPassword());
            //user.setPassword(encrypted_password);
            return optionalUser.get();
        }
        else {
            System.out.println("User with name "+username+" does not exist");
            throw new UsernameNotFoundException(MessageFormat.format("User with username {0} cannot be found.", username));
        }
    }

    public void signUpUser(UserDTO userDto) 
    {
        System.out.println(userDto.toString());
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        final String encryptedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        System.out.println("password = "+encryptedPassword);
        MyUser myUser=new MyUser();
        myUser.setId(userRepository.count()+1);
        myUser.setUsername(userDto.getUsername());
        myUser.setEmail(userDto.getEmail());
        myUser.setPassword(encryptedPassword);
        System.out.println(myUser.toString());
        userRepository.save(myUser);
        
        System.out.println("user named "+myUser.getUsername()+" added to database");
    }

    
}
