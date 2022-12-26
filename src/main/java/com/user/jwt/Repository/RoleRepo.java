package com.user.jwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.jwt.Entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
