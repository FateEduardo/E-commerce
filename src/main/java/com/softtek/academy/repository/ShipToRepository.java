package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.ShipTo;

@Repository
public interface ShipToRepository extends JpaRepository<ShipTo, Long> {

}
