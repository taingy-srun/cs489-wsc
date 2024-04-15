package edu.miu.cs489.wsc.repository;

import edu.miu.cs489.wsc.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    List<ShoppingCart> findAllByCustomer_CustomerId(Integer customerId);
}
