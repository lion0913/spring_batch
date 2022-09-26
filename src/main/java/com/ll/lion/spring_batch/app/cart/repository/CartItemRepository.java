package com.ll.lion.spring_batch.app.cart.repository;

import com.ll.lion.spring_batch.app.cart.entity.CartItem;
import com.ll.lion.spring_batch.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByMemberIdAndProductOptionId(Long id, Long optionId);

    List<CartItem> findAllByMemberId(Long memberId);
}
