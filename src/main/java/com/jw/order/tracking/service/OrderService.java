package com.jw.order.tracking.service;

import com.jw.order.tracking.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addOrder(Order order) {
        mongoTemplate.insert(order, "order");
    }
}
