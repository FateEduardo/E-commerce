package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
