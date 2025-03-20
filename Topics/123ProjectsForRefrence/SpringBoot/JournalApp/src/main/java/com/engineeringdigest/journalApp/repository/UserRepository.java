package com.engineeringdigest.journalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.engineeringdigest.journalApp.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String name);
}
