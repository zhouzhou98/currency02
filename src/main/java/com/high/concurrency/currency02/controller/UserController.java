package com.high.concurrency.currency02.controller;

import com.high.concurrency.currency02.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("export")
    public String export() {
        return userService.exportData();
    }
}
