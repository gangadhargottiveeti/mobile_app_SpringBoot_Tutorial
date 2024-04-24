package com.TW.mobile_app_ws.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping()
    public String getUsers(@RequestParam("page") int page){
        return "get user was called with page = "+page;
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable String userId){
        return "get user was called with userId : "+userId ;
    }

    @PostMapping()
    public String createUser(){
        return "create user was called";
    }

    @PutMapping()
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping()
    public String deleteUser(){
        return "delete user was called";
    }
}
