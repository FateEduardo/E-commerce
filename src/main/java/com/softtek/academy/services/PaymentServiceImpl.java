package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.Payment;
import com.softtek.academy.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

}
