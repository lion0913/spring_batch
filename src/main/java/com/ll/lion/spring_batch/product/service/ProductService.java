package com.ll.lion.spring_batch.product.service;

import com.ll.lion.spring_batch.product.entity.Product;
import com.ll.lion.spring_batch.product.entity.ProductOption;
import com.ll.lion.spring_batch.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void create(String name, int price, String makerShopName, List<ProductOption> options) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .makerShopName(makerShopName)
                .build();

        productRepository.save(product);

        for(ProductOption option : options) {
            product.addOption(option);
        }

        productRepository.save(product);
    }

}
