package com.user.jwt.Services.ImplentedServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.jwt.Entity.User;
import com.user.jwt.Payload.UserDio;
import com.user.jwt.Repository.UserRepo;
import com.user.jwt.Services.UserServices;

@Service
public class UserImplServices implements UserServices {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDio createUser(UserDio UserDio) {

        User User = this.modelMapper.map(UserDio, User.class);

        User saveUser = this.userRepo.save(User);
        return this.modelMapper.map(saveUser, UserDio.class);

    }

    @Override
    public void deleteUser(Integer lid) {
        User user = this.userRepo.findById(lid)
                .orElseThrow();
        this.userRepo.delete(user);

    }
}
