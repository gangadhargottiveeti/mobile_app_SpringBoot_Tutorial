package com.TW.mobile_app_ws.userservice.impl;

import com.TW.mobile_app_ws.shared.Utils;
import com.TW.mobile_app_ws.ui.model.request.UserDetailsRequestModel;
import com.TW.mobile_app_ws.ui.model.response.UserRest;
import com.TW.mobile_app_ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if(users == null) {
            users = new HashMap<>();
        }
        users.put(userId, returnValue);
        return returnValue;
    }
}
