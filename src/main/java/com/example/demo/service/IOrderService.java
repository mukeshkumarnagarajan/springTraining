package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Orders;

public interface IOrderService {

	void saveOrder(Orders order);
	
	List<Orders> getOrders();
}
