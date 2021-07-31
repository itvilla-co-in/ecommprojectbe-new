package com.itvilla.ecomm.prod.dto;

import com.itvilla.ecomm.prod.entity.Address;
import com.itvilla.ecomm.prod.entity.Customer;
import com.itvilla.ecomm.prod.entity.Order;
import com.itvilla.ecomm.prod.entity.OrderItem;
import lombok.Data;

import java.util.Set;
@Data
public class myorder {

    private Customer customer;
    private Address deliveryAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
