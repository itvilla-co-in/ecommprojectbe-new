package com.itvilla.ecomm.prod.dao;

 import com.itvilla.ecomm.prod.entity.Product;
 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.RequestParam;
 import com.itvilla.ecomm.prod.entity.Product;

 import java.util.List;
 import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    //List<Product> findByCategoryId(@RequestParam("id") Long id);

    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

   Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
