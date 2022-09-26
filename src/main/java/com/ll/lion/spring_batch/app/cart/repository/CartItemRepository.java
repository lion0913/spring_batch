package com.ll.lion.spring_batch.app.cart.repository;

import com.ll.lion.spring_batch.app.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByMemberIdAndProductOptionId(Long id, Long optionId);
}
