package com.user.jwt.Security;

import lombok.Data;

@Data
public class JwtAuthRequest {
    private String name;
    private String password;

}
