package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {

}
