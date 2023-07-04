package coupang.SaleItem.service;

import coupang.SaleItem.dto.UserDto;
import coupang.SaleItem.entity.User;
import coupang.SaleItem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void join(UserDto userDto){
        User user = new User();


    }

}
