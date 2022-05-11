package com.example.core.order;

public interface OrderService {
	Order createOrder(Long id, String itemName, int itemPrice);
}
