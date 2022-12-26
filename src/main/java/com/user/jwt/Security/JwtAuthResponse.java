package com.user.jwt.Security;

import com.user.jwt.Payload.UserDio;

import lombok.Data;

@Data
public class JwtAuthResponse {
    private String token;
    private UserDio user;
}
