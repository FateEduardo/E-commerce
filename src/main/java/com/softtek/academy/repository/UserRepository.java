package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
