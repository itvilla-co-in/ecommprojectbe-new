package com.itvilla.ecomm.prod.dao;

 import com.itvilla.ecomm.prod.entity.Customer;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail);

}


