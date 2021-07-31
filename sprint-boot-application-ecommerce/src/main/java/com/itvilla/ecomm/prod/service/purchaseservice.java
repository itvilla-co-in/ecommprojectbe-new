package com.itvilla.ecomm.prod.service;

import com.itvilla.ecomm.prod.dto.myorder;
import com.itvilla.ecomm.prod.dto.orderresponse;

public interface purchaseservice {

    orderresponse placeOrder(myorder myorder);

}
