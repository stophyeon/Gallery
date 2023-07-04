package coupang.SaleItem.controller;

import coupang.SaleItem.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    private final UserService userService;


    public HomeController(UserService userService) {
        this.userService = userService;
    }
}
