package com.user.jwt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.jwt.Payload.UserDio;
import com.user.jwt.Services.UserServices;

@RestController
@RequestMapping("/user/")
public class UserConstroller {
    @Autowired
    private UserServices userServices;

    @PostMapping("/add/")
    public ResponseEntity<UserDio> createEmployee(
            @RequestBody UserDio UserDio

    ) {
        UserDio createUser = this.userServices.createUser(UserDio);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser:{id}/")
    public ResponseEntity<UserDio> deleteUser(@PathVariable Integer id) {
        this.userServices.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
