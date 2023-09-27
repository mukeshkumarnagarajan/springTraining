package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.IOrderRepository;
import com.example.demo.Orders;

@Service
public class OrderService implements IOrderService {

	@Autowired
	IOrderRepository repository;
	
	@Override
	@Transactional
	public void saveOrder(Orders order) {
		order.setCreatedDate(new Date());
		repository.save(order);
		System.out.println(order.getItem());
		//throw new IllegalAccessError("Something went Wrong");
	}

	@Override
	public List<Orders> getOrders() {
		return repository.findAll();
	}
}
