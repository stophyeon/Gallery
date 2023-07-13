package com.example.movie.service;

import com.example.movie.dto.LoginForm;

import com.example.movie.dto.UserDto;
import com.example.movie.entity.MyMovies;
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
    public User join(LoginForm loginForm){
        User findByPwUser = userRepository.findByPassword(loginForm.getPassword()).orElseThrow(NullPointerException::new);
        User findByEmailUser = userRepository.findByEmail(loginForm.getEmail()).orElseThrow(NullPointerException::new);
        if (findByEmailUser.equals(findByPwUser)){
            return findByEmailUser;
        }
        else return null;

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
    public User findOne(String email){
        User user = userRepository.findByEmail(email).orElseThrow();
        return user;
    }
    public void addMyMovies(MyMovies myMovies,User user){

        user.makeMyMovies(myMovies);
    }

}