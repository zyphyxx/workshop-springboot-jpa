package com.zpx.purchasingsystem.resources;

import com.zpx.purchasingsystem.domains.dto.ProductDTO;
import com.zpx.purchasingsystem.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts() {
        return ResponseEntity.ok().body(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductDTO>> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    /*
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO products){
        ProductDTO newObj = productService.createProduct(products);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newObj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @PutMapping("/{id}")
    public void updateProduct (@RequestBody Product product, @PathVariable Long id) {
        product.setId(id);
         productService.updateProduct(product); }
         */


}
