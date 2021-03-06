package com.jw.order.tracking.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jw.order.tracking.common.MyFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * POJO of logistics info
 */
@Data()
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Logistics {

    /**
     * order id
     */
    private int orderId;


    /**
     * current logistics operation
     */
    private String operation;
    /**
     * current logistics operator
     */
    private String operator;
    /**
     * Operation address
     */
    private String address;
    /**
     * detailed info (comment)
     */
    private String details;


    /**
     * operation time
     */
    @JsonFormat(pattern = MyFormat.DATE_JSON)
    private Date operationTime;
}
