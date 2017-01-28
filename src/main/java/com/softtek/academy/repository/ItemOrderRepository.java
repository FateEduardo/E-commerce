package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.ItemOrder;


@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {

}
