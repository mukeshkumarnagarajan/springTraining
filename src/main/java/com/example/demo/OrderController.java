package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IOrderService;

import jakarta.validation.Valid;

@RequestMapping("/order")
@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void createOrder(@Valid @RequestBody Orders order) {
		System.out.println(order.getItem());
		orderService.saveOrder(order);
	}
	
	@GetMapping
	List<Orders> getOrders(){
		return orderService.getOrders();
	}
	
	@GetMapping("/{id}")
	Orders getOrders(@PathVariable Integer id){
		return orderService.getOrdersbyId(id);
	}
	
	@DeleteMapping("/{id}")
	void deleteOrrders(@PathVariable Integer id){
		orderService.deleteOrder(id);
	}
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception){
		Map<String, String> errorMessages = new HashMap<>();
		List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
		allErrors.forEach((error) -> {
			FieldError fieldError = ((FieldError)error);
			String fieldName = fieldError.getField();
			String errorMessage = fieldError.getDefaultMessage();
			errorMessages.put(fieldName, errorMessage);
		});
		return errorMessages;
	}
}
