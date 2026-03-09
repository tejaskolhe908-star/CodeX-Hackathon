package com.smartnoticeboard.repository;


import com.smartnoticeboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}