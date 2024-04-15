package edu.miu.cs489.wsc.controller;

import edu.miu.cs489.wsc.dto.ProductCreationDTO;
import edu.miu.cs489.wsc.dto.ProductDTO;
import edu.miu.cs489.wsc.dto.ProductUpdateDTO;
import edu.miu.cs489.wsc.model.Product;
import edu.miu.cs489.wsc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<Product> products = service.getAll();
        return ResponseEntity.ok(toProductDTOList(products));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Integer categoryId) {
        List<Product> products = service.getAllByCategory(categoryId);
        return ResponseEntity.ok(toProductDTOList(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        Product product = service.getOne(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.toProductDTO());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductCreationDTO productCreationDTO) {
        Product addedProduct = service.save(productCreationDTO.toProduct());
        return ResponseEntity.ok(addedProduct.toProductDTO());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody ProductCreationDTO productCreationDTO) {
        Product findProduct = service.getOne(id);
        if (findProduct == null) {
            return ResponseEntity.notFound().build();
        }
        ProductUpdateDTO productUpdateDTO = new ProductUpdateDTO(id, productCreationDTO);
        Product updatedProduct = service.save(productUpdateDTO.toProduct());
        return ResponseEntity.ok(updatedProduct.toProductDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        Product findProduct = service.getOne(id);
        if (findProduct == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(findProduct);
        return ResponseEntity.ok("Product deleted successfully!");
    }

    private List<ProductDTO> toProductDTOList(List<Product> products) {
        return products.stream()
                .map(Product::toProductDTO)
                .collect(Collectors.toList());
    }
}
