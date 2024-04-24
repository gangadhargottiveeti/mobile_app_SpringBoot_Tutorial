package com.TW.mobile_app_ws.controller;

import com.TW.mobile_app_ws.exception.UserServiceException;
import com.TW.mobile_app_ws.ui.model.request.UserDetailsRequestModel;
import com.TW.mobile_app_ws.ui.model.request.updateUserDetailsRequestModel;
import com.TW.mobile_app_ws.ui.model.response.UserRest;
import com.TW.mobile_app_ws.userservice.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    Map<String, UserRest> users;
    @Autowired
    UserService userService;

    @GetMapping()
    public Map<String, UserRest> getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit",defaultValue = "40") int limit){
        return users;
    }


    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

//        String firstName = null;
//        int firstNameLength = firstName.length();
//        if(true){
//            throw new UserServiceException("A user service expection is thrown");
//        }

        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
        },
            produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = userService.createUser(userDetails);

        return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
    }


    @PutMapping("/{userId}")
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody updateUserDetailsRequestModel userDetails){
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        users.remove(id);
        return new ResponseEntity("Deleted Successfully",HttpStatus.NO_CONTENT);
    }
}
