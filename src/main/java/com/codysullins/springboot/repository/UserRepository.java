package com.codysullins.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codysullins.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
