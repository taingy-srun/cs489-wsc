package edu.miu.cs489.wsc.controller;

import edu.miu.cs489.wsc.dto.AddToCartDTO;
import edu.miu.cs489.wsc.model.ShoppingCart;
import edu.miu.cs489.wsc.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingController {

    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addProductToCart(@RequestBody AddToCartDTO addToCartDTO) {
        shoppingCartService.addToCart(addToCartDTO.toShoppingCart());
        return ResponseEntity.ok("Added to cart!");
    }

    @GetMapping("/{customerId}/shopping-cart")
    public ResponseEntity<List<ShoppingCart>> getCustomerShoppingCart(@PathVariable Integer customerId) {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getAllByCustomerId(customerId);
        return ResponseEntity.ok(shoppingCarts);
    }
}
