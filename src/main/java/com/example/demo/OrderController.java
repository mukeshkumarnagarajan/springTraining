package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IOrderService;
import com.example.demo.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@PostMapping("/order")
	void createOrder(@Valid @RequestBody Order order) {
		System.out.println(order.getItem());
		orderService.saveOrder(order);
	}
	
	@GetMapping("/order")
	List<Order> getOrders(){
		return null;
	}
}
