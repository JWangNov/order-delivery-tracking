package com.jw.order.tracking.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * POJO of order info, which has a list of logistics info
 */
@Data()
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    /**
     * order id
     */
    private int id;
    /**
     * order status
     */
    private String status;


    /**
     * shipped (or will be shipped) from who
     */
    private String shipper;
    /**
     * shipped (or will be shipped) from where
     */
    private String shippingAddress;
    /**
     * phone number of the shipper
     */
    private long shipperPhone;


    /**
     * shipped (or will be shipped) to whom
     */
    private String receiver;
    /**
     * shipped (or will be shipped) to where
     */
    private String receiverAddress;
    /**
     * phone number of the shipper
     */
    private long receiverPhone;


    /**
     * order time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;
    /**
     * shipped time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date shipTime;


    /**
     * related logistics info
     */
    private List<Logistics> logistics;
}
