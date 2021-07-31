package com.itvilla.ecomm.prod.service;

import com.itvilla.ecomm.prod.dao.CustomerRepo;
import com.itvilla.ecomm.prod.dto.myorder;
import com.itvilla.ecomm.prod.dto.orderresponse;
import com.itvilla.ecomm.prod.entity.Customer;
import com.itvilla.ecomm.prod.entity.Order;
import com.itvilla.ecomm.prod.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;
@Service
public class purchaseserviceimpl implements purchaseservice{
    private CustomerRepo customerRepository;

    public purchaseserviceimpl(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public orderresponse placeOrder(myorder myorder){
        Order order = myorder.getOrder();
        String orderNumber = generateOrderNumber();
        order.setOrderTrackingNumber(orderNumber);
        System.out.println("from purchase server *****" + order.getOrderTrackingNumber());
        Set<OrderItem> orderItems = myorder.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        order.setBillingAddress(myorder.getBillingAddress());
        order.setShippingAddress(myorder.getDeliveryAddress());
        Customer customer = myorder.getCustomer();
        System.out.println("from purchase server *****" + customer.getEmail());

        String theEmail = customer.getEmail();
        Customer tempcust = customerRepository.findByEmail(theEmail);
        if (tempcust != null) {
            // we found them ... let's assign them accordingly
            customer = tempcust;
        }
        customer.add(order);
        customerRepository.save(customer);
        return new orderresponse(orderNumber);
    }

    private String generateOrderNumber() {

        // generate a random UUID number (UUID version-4)

        return UUID.randomUUID().toString();
    }

}
