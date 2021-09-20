package com.everis.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.data.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
