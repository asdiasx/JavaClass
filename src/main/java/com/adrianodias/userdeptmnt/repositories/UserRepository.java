package com.adrianodias.userdeptmnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianodias.userdeptmnt.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}
