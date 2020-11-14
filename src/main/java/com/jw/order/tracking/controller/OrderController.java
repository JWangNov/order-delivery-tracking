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
import java.util.Map;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("add-order")
    public String addOrder(Order order) {
        // FIXME: for now, we simplify this part
        //  once added an order, mark it as "shipped", and set the ship time as current time
        Date date = new Date();
        order.setStatus(OrderStatus.SHIPPED)
                .setOrderTime(date)
                .setShipTime(date);
        orderService.addOrder(order);
        log.info("[addOrder] add order #{}", order.getId());
        return "add success";
    }

    @PostMapping("update-order")
    public String updateOrder(Logistics logistics) {
        Date date = new Date();
        logistics.setOperationTime(date);
        orderService.addLogisticsAndUpdateStatus(logistics);
        log.info("[updateOrder] update order #{}, operation: {}", logistics.getOrderId(), logistics.getOperation());
        return "update success";
    }

    @GetMapping("get-order-by-id")
    public Order getOrderById(int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("delete-order-by-id")
    public String deleteOrderById(int id) {
        // if (orderService.deleteOrderById(id)){
        //     return "success delete";
        // }
        // return "fail delete";
        boolean isDeleted = orderService.deleteOrderById(id);
        if (isDeleted) {
            log.info("[deleteOrderById] successfully delete order #{}", id);
            return "success delete";
        } else {
            log.debug("[deleteOrderById] failed to delete order #{}", id);
            return "fail delete";
        }
    }

    @GetMapping("get-all-order")
    public Map<String, Object> getAllOrder() {
        var list = orderService.getAllOrder();
        return Map.of(
                "code", 0,
                "count", list.size(),
                "data", list
        );
    }
}
