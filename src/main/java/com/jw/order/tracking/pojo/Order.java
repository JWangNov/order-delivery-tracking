package com.jw.order.tracking.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jw.order.tracking.common.MyFormat;
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
     * shipped (or will be shipped) from whom
     */
    private String shipper;
    /**
     * shipped (or will be shipped) from where
     */
    private String shipperAddress;
    /**
     * phone number of the shipper
     */
    private long shipperPhone;


    /**
     * shipped (or will be shipped) to whom
     */
    private String recipient;
    /**
     * shipped (or will be shipped) to where
     */
    private String recipientAddress;
    /**
     * phone number of the recipient
     */
    private long recipientPhone;


    /**
     * order time
     */
    @JsonFormat(pattern = MyFormat.DATE_JSON)
    private Date orderTime;
    /**
     * shipped time
     */
    @JsonFormat(pattern = MyFormat.DATE_JSON)
    private Date shipTime;


    /**
     * related logistics info
     */
    private List<Logistics> logistics;
}
