package com.user.jwt.Services;

import java.util.List;

import com.user.jwt.Payload.UserDio;

public interface UserServices {
    UserDio createUser(UserDio UserDio);

    void deleteUser(Integer userId);

    List<UserDio> getAllUser();

}
