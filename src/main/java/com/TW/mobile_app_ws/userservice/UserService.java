package com.TW.mobile_app_ws.userservice;

import com.TW.mobile_app_ws.ui.model.request.UserDetailsRequestModel;
import com.TW.mobile_app_ws.ui.model.response.UserRest;
import org.springframework.stereotype.Service;


public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
