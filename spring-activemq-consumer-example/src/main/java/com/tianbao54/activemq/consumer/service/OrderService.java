package com.tianbao54.activemq.consumer.service;

import com.tianbao54.activemq.model.Product;

public interface OrderService {

	public void processOrder(Product product);
}
