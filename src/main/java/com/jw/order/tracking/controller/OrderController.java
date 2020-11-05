package com.jw.order.tracking.controller;

import com.jw.order.tracking.common.OrderStatus;
import com.jw.order.tracking.pojo.Order;
import com.jw.order.tracking.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("add-order")
    public String addOrder(Order order) {
        // FIXME: for now, we simplify this part
        //  once added an order, mark it as "shipped", and set the ship time as current time
        order.setStatus(OrderStatus.SHIPPED)
                .setOrderTime(new Date())
                .setShipTime(new Date());
        orderService.addOrder(order);
        return "success adding the order";
    }
}
