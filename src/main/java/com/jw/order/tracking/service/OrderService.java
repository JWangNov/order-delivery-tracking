package com.jw.order.tracking.service;

import com.jw.order.tracking.pojo.Logistics;
import com.jw.order.tracking.pojo.Order;
import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    private static final String COLLECTION_NAME_ORDER = "order";

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addOrder(Order order) {
        mongoTemplate.insert(order, COLLECTION_NAME_ORDER);
    }

    public void addLogisticsAndUpdateStatus(Logistics logistics) {
        Query query = Query.query(Criteria.where("_id").is(logistics.getOrderId()));
        Update update = new Update()
                // use the operation of logistics as order status update
                .set("status", logistics.getOperation())
                .push("logistics", logistics);
        mongoTemplate.upsert(query, update, Order.class, COLLECTION_NAME_ORDER);
    }

    public Order getOrderById(int id) {
        return mongoTemplate.findById(id, Order.class, COLLECTION_NAME_ORDER);
    }

    public List<Order> getAllOrder() {
        return mongoTemplate.findAll(Order.class, COLLECTION_NAME_ORDER);
    }

    public boolean deleteOrderById(int id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        DeleteResult deleteResult = mongoTemplate.remove(query, Order.class, COLLECTION_NAME_ORDER);
        return deleteResult.wasAcknowledged();
    }
}
