package com.user.jwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.jwt.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
