package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.ShipTo;
import com.softtek.academy.repository.ShipToRepository;

@Service
public class ShipToServiceImpl implements ShipToService {

	@Autowired
	ShipToRepository shipToRepository;
	@Override
	public List<ShipTo> findAll() {
		// TODO Auto-generated method stub
		return shipToRepository.findAll();
	}

}
