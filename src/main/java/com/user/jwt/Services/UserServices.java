package com.user.jwt.Services;

import com.user.jwt.Payload.UserDio;

public interface UserServices {
    UserDio createUser(UserDio UserDio);

    void deleteUser(Integer userId);

}
