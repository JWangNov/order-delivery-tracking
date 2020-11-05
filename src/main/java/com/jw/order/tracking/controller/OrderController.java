package com.jw.order.tracking.controller;

import com.jw.order.tracking.common.OrderStatus;
import com.jw.order.tracking.pojo.Logistics;
import com.jw.order.tracking.pojo.Order;
import com.jw.order.tracking.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "add success";
    }

    @PostMapping("update-order")
    public String updateOrder(Logistics logistics) {
        logistics.setOperationTime(new Date());
        orderService.addLogisticsAndUpdateStatus(logistics);
        return "update success";
    }

    @GetMapping("get-order-by-id")
    public Order getOrderById(int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("delete-order-by-id")
    public String deleteOrderById(int id) {
        return orderService.deleteOrderById(id) ? "success delete" : "fail delete";
    }
}
