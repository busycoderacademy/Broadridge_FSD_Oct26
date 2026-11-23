package com.bankapp.config;

import com.bankapp.repo.UserEntity;
import com.bankapp.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Who will call this code spring sec call this code
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userEntityService.findByUsername(username);

        if(userEntity==null){
            throw new UsernameNotFoundException("username/password is wrong");// 401
        }
        //if user is found u need to return a object of UserDetails not UserEntity
        //now i need to write the logic to convert UserEntity object to what spring sec understood UserDetails?
        return new SecUser(userEntity);
    }
}
