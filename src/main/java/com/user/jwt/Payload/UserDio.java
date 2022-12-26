package com.user.jwt.Payload;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDio {
    private int id;
    private String name;
    private String password;
    private Set<RoleDio> roles = new HashSet<>();

}
