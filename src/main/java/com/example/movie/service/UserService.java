package com.example.movie.service;

import com.example.movie.dto.LoginForm;
import com.example.movie.dto.SearchReq;
import com.example.movie.dto.SearchRes;
import com.example.movie.dto.UserDto;
import com.example.movie.entity.User;
import com.example.movie.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean join(LoginForm loginForm){
        Optional<User> findByPwUser = userRepository.findByPassword(loginForm.getPassword());
        Optional<User> findByEmailUser = userRepository.findByEmail(loginForm.getEmail());
        if (findByEmailUser.equals(findByPwUser)){return true;}
        else {return false;}

    }
    public void createUser(UserDto userdto) {
        User user = new User(userdto.getUserName(),userdto.getPassword(),userdto.getEmail(), userdto.getPhoneNumber());
        DuplicateEmail(user);
        userRepository.save(user);
    }
    public void DuplicateEmail(User user){
        userRepository.findByEmail(user.getEmail()).ifPresent(
                m-> {
                    throw new IllegalStateException("이미 가입된 email입니다");}
        );
    }

}