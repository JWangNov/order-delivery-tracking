package com.jw.order.tracking.common;

import com.jw.order.tracking.pojo.Logistics;

/**
 * This only contains some key status of an order.
 * <p>
 * Generally, the order should use the latest {@link Logistics#getOperation()} as its status.
 */
public class OrderStatus {
    public static final String PREPARING = "preparing for shipment";
    public static final String SHIPPED = "shipped";
    public static final String OUT_DELIVERY = "out for delivery";
    public static final String DELIVERED = "delivered";
}
