package com.TW.mobile_app_ws.controller;

import com.TW.mobile_app_ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit",defaultValue = "40") int limit){
        return "get user was called with page = "+page+" and limit = "+limit;
    }


    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Gangadhar");
        returnValue.setLastName("Gottiveeti");
        returnValue.setEmail("gottiveetigangadhar@gmail.com");
        returnValue.setUserId(2);
        return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
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
