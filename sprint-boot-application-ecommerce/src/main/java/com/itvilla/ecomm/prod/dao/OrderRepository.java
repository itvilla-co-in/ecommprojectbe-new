package com.itvilla.ecomm.prod.dao;

import com.itvilla.ecomm.prod.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface OrderRepository extends JpaRepository<Order, Long> {

    //Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);
    //http://localhost:8181/api/orders/search/findByCustomerEmail?email=naren_kang@yahoo.com
    Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);
}